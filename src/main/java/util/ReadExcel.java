package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.LoaiSanPhamDao;
import dao.SanPhamDao;
import dao.Ipml.LoaiSanPhamImpl;
import dao.Ipml.SanPhamImpl;
import entity.LoaiSanPham;
import entity.SanPham;


public class ReadExcel {
	 	public static final int COLUMN_INDEX_TEN = 0;
	    public static final int COLUMN_INDEX_KICHTHUOC = 1;
	    public static final int COLUMN_INDEX_CHATLIEU = 2;
	    public static final int COLUMN_INDEX_MAUSAC = 3;
	    public static final int COLUMN_INDEX_LOAISANPHAM = 4;
	    public static final int COLUMN_INDEX_NHANHIEU = 5;
	    public static final int COLUMN_INDEX_HINHANH = 6;
	    public static final int COLUMN_INDEX_SOLUONG = 7;
	    public static final int COLUMN_INDEX_GIABAN = 8;
	    private static LoaiSanPhamDao loaiSanPhamDao;
	    private static SanPhamDao sanPhamDao;
	    
	    public static void main(String[] args) throws IOException {
	        final String excelFilePath = "data//nhaphang.xlsx";
	        final List<SanPham> sanPhams = readExcel(excelFilePath);
	        for (SanPham sanPham : sanPhams) {
	        	System.out.println(sanPham);
	        }
	    }
	 	    
	    public static List<SanPham> readExcel(String excelFilePath) throws IOException {
	    	loaiSanPhamDao = new LoaiSanPhamImpl();
	    	sanPhamDao = new SanPhamImpl();
	    	
	        List<SanPham> listSP = new ArrayList<>();
	 
	        // Get file
	        InputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	        // Get workbook
	        Workbook workbook = getWorkbook(inputStream, excelFilePath);
	 
	        // Get sheet
	        Sheet sheet = workbook.getSheetAt(0);
	 
	        // Get all rows
	        Iterator<Row> iterator = sheet.iterator();
	        String spCuoi = sanPhamDao.getMaSanPhamCuoi().substring(2);
            int maSPNum = Integer.parseInt(spCuoi);
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            if (nextRow.getRowNum() == 0) {
	                // Ignore header
	                continue;
	            }
	 
	            // Get all cells
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	 
	            // Read cells and set value for book object
	            SanPham sanPham = new SanPham();
	            sanPham.setTrangThaiKD(true);
	            
	            maSPNum ++;
	            String maSP = String.format("SP%06d",maSPNum);
	            sanPham.setMaSP(maSP);
	            while (cellIterator.hasNext()) {
	                //Read cell
	                Cell cell = cellIterator.next();
	                Object cellValue = getCellValue(cell);
	                if (cellValue == null || cellValue.toString().isEmpty()) {
	                    continue;
	                }
	                // Set value for book object
	                int columnIndex = cell.getColumnIndex();
	                switch (columnIndex) {
	                case COLUMN_INDEX_TEN:
	                	sanPham.setTenSP((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_KICHTHUOC:
	                	sanPham.setKichThuoc((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_CHATLIEU:
	                	sanPham.setChatLieu((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_MAUSAC :
	                	sanPham.setMauSac((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_LOAISANPHAM:
	                    LoaiSanPham loaiSanPham = loaiSanPhamDao.getLoaiSanPhamByName((String) getCellValue(cell));
	                    sanPham.setLoaiSanPham(loaiSanPham);
	                    break;
	                case COLUMN_INDEX_NHANHIEU:
	                    sanPham.setNhanHieu((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_HINHANH:
	                    sanPham.setHinhAnh((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_SOLUONG:
	                	Double sl = (Double) getCellValue(cell);
	                	String numString = String.valueOf(sl);
	                	String numSub = numString.substring(0, numString.length()-2);
	                    sanPham.setSoLuong(Integer.parseInt(numSub));
	                    break;
	                case COLUMN_INDEX_GIABAN:
	                    sanPham.setDonGia((double) getCellValue(cell));
	                    break;
	                default:
	                    break;
	                }
	 
	            }
	            listSP.add(sanPham);
	        }
	 
	        workbook.close();
	        inputStream.close();
	 
	        return listSP;
	    }
	 
	    // Get Workbook
	    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
	        Workbook workbook = null;
	        if (excelFilePath.endsWith("xlsx")) {
	            workbook = new XSSFWorkbook(inputStream);
	        } else if (excelFilePath.endsWith("xls")) {
	            workbook = new HSSFWorkbook(inputStream);
	        } else {
	            throw new IllegalArgumentException("The specified file is not Excel file");
	        }
	 
	        return workbook;
	    }
	 
	    // Get cell value
	    private static Object getCellValue(Cell cell) {
	        CellType cellType = cell.getCellTypeEnum();
	        Object cellValue = null;
	        switch (cellType) {
	        case BOOLEAN:
	            cellValue = cell.getBooleanCellValue();
	            break;
	        case FORMULA:
	            Workbook workbook = cell.getSheet().getWorkbook();
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            cellValue = evaluator.evaluate(cell).getNumberValue();
	            break;
	        case NUMERIC:
	            cellValue = cell.getNumericCellValue();
	            break;
	        case STRING:
	            cellValue = cell.getStringCellValue();
	            break;
	        case _NONE:
	        case BLANK:
	        case ERROR:
	            break;
	        default:
	            break;
	        }
	 
	        return cellValue;
	    }
	}

