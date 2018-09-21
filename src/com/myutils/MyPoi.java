package com.myutils;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.CheLiang;
import com.entity.Customer;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.service.CheLiangService;
import com.service.CustomerService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

/**
 *  导出 excel
 */
public class MyPoi {
	/**
	 * 构造方法
	 */
	public MyPoi() {
		super();
	}

	/**
	 *  设置cell样式
	 */
	public static void setCellStyle(Cell cell , HSSFCellStyle cellStyle ,String value){
		cell.setCellStyle(cellStyle);
		cell.setCellValue(value);
	}
	
	/**
	 *  设置属性行 的 值和样式
	 */
	public static void setParaCell(Row paraRow, HSSFWorkbook wb){
		
//		设置Excel单元格格式样式（居中，字体，边框等）对象
		HSSFCellStyle cellStyle = wb.createCellStyle();
//		设置字体
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);//设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
//		添加字体样式
		cellStyle.setFont(font);
//		设置居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中  
		
		Cell paraCell0 =paraRow.createCell(0);
		setCellStyle(paraCell0, cellStyle, "序号");
		
		Cell paraCell1 =paraRow.createCell(1);
		setCellStyle(paraCell1, cellStyle, "运输时间");
		
		Cell paraCell2 =paraRow.createCell(2);
		setCellStyle(paraCell2, cellStyle, "车号");
		
		Cell paraCell3 =paraRow.createCell(3);
		setCellStyle(paraCell3, cellStyle, "属地");
		
		Cell paraCell4 =paraRow.createCell(4);
		setCellStyle(paraCell4, cellStyle, "发货单位");

		Cell paraCell5 =paraRow.createCell(5);
		setCellStyle(paraCell5, cellStyle, "货物名称");
		
		Cell paraCell6 =paraRow.createCell(6);
		setCellStyle(paraCell6, cellStyle, "实收吨位");
		
		Cell paraCell7 =paraRow.createCell(7);
		setCellStyle(paraCell7, cellStyle, "实发吨位");
		
		Cell paraCell8 =paraRow.createCell(8);
		setCellStyle(paraCell8, cellStyle, "里程");
		
		Cell paraCell9 =paraRow.createCell(9);
		setCellStyle(paraCell9, cellStyle, "单价");
		
		Cell paraCell10 =paraRow.createCell(10);
		setCellStyle(paraCell10, cellStyle, "带空桶");
		
		Cell paraCell11 =paraRow.createCell(11);
		setCellStyle(paraCell11, cellStyle, "起点");
		
		Cell paraCell12 =paraRow.createCell(12);
		setCellStyle(paraCell12, cellStyle, "终点");
		
		Cell paraCell13 =paraRow.createCell(13);
		setCellStyle(paraCell13, cellStyle, "营收");
		
		Cell paraCell14 =paraRow.createCell(14);
		setCellStyle(paraCell14, cellStyle, "到账时间");
		
		Cell paraCell15 =paraRow.createCell(15);
		setCellStyle(paraCell15, cellStyle, "发票号");
		
		Cell paraCell16 =paraRow.createCell(16);
		setCellStyle(paraCell16, cellStyle, "开票时间");
		
		Cell paraCell17 =paraRow.createCell(17);
		setCellStyle(paraCell17, cellStyle, "税金");
		
		Cell paraCell18 =paraRow.createCell(18);
		setCellStyle(paraCell18, cellStyle, "管理费");
		
		Cell paraCell19 =paraRow.createCell(19);
		setCellStyle(paraCell19, cellStyle, "代垫费");
		
		Cell paraCell20 =paraRow.createCell(20);
		setCellStyle(paraCell20, cellStyle, "实付运费");
		
		Cell paraCell21 =paraRow.createCell(21);
		setCellStyle(paraCell21, cellStyle, "领款时间");
		
		Cell paraCell22 =paraRow.createCell(22);	
		setCellStyle(paraCell22, cellStyle, "签收");
		
		Cell paraCell23 =paraRow.createCell(23);	
		setCellStyle(paraCell23, cellStyle, "租车费");

		Cell paraCell24 =paraRow.createCell(24);	
		setCellStyle(paraCell24, cellStyle, "业务费");
		
		Cell paraCell25 =paraRow.createCell(25);	
		setCellStyle(paraCell25, cellStyle, "备注");
	}
	
	/**
	 *  设置参数值
	 */
	public static void setParaExcelValue( HSSFSheet sheet, HSSFWorkbook wb , CustomerService customerService ,CheLiangService cheLiangService){
//		设置Excel单元格格式样式（居中，字体，边框等）对象
		HSSFCellStyle cellStyle = wb.createCellStyle();
//		设置字体
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);//设置字体大小
//		添加字体样式
		cellStyle.setFont(font);
//		设置居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中  
		
//		开始填写数据
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		营收款 业务对象
		YingShouKuanService ysks = (YingShouKuanService) ac.getBean("yingShouKuanService");	
//		运单业务对象
		YunDanService yds = (YunDanService) ac.getBean("yunDanService");
//		车辆业务对象
		CheLiangService cls = (CheLiangService) ac.getBean("cheLiangService");
//		查询所有营收款
		List<YingShouKuan> yingshoukuanlist = ysks.queryYingShouKuanList();
		
		for (int i = 0; i < yingshoukuanlist.size() ; i++) {
			
			try {
				
	//			得到营收款对象 
				YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
	//			订单号
				String dingdanhao = yingshoukuan.getDingdanhao();
	//			得到运单对象
				YunDan yundan = yds.queryYunDanDingDanHao(dingdanhao);
				if(yundan == null ){
					continue;
				}
	//			车牌号
				String chepaihao = yundan.getChepaihao();
	//			格式化日期对象
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	//			运输时间
				String yunshushijian = "";
				if(yundan.getYunshushijian() != null){
					yunshushijian = sdf.format( yundan.getYunshushijian() ); 
				}
	//			属地
				String shudi = "";
				
				CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);	
				if(cheliang != null){
					shudi = cheliang.getChezhuxingming();	//车主姓名
				}
				
	//			发货单位
				String fahuodanwei ="";
				try {
					 Customer customer = customerService.queryKehudanwei(FormatValueClass.getFormatValueClass(yundan.getKehudanwei()));
					 if(customer != null){
						 fahuodanwei = customer.getShortname();
					 }
				} catch (Exception e) {
				}
				
	//			货物名称
				String huowumingcheng = yundan.getHuowumingcheng();
	//			实收吨位
				String shishoudunwei = yundan.getShishoudunwei();
	//			实发吨位
				String shifadunwei = yundan.getShifadunwei();
	//			里程
				String licheng = yundan.getLicheng();
	//			单价
				String danjia = yundan.getBaochoujine();
	//			带空桶
				String daikongtong = yingshoukuan.getDaikongtong();
	//			起点
				String qidian = yundan.getQidian();
	//			终点
				String zhongdian = yundan.getZhongdian();
	//			营收
				String yingshou = yingshoukuan.getYingshou();
	//			到账时间
				String daozhangshijian = "";
				if( yingshoukuan.getDaozhangshijian() != null ){
					daozhangshijian = sdf.format( yingshoukuan.getDaozhangshijian() );
				}
	//			发票号
				String fapiaohao = yingshoukuan.getFapiaohao();
	//			开票时间
				String kaipiaoshijian = "";
				if( yingshoukuan.getKaipiaoshijian() != null ){
					kaipiaoshijian = sdf.format( yingshoukuan.getKaipiaoshijian() );
				}
	//			税金
				String shuijin = yingshoukuan.getShuijin();
	//			管理费
				String guanlifei = yingshoukuan.getGuanlifei();
	//			代垫费
				String daidianfei = yundan.getDaidianfei();
	//			实付运费
				String shifuyunfei = yingshoukuan.getShifuyunfei();
	//			领款时间
				String lingkuanshijian = "";
				if( yingshoukuan.getLingkuanshijian() != null ){
					lingkuanshijian = sdf.format( yingshoukuan.getLingkuanshijian() );
				}
	//			签收
				String qianshou = yingshoukuan.getQianshou();
	//			备注
				String beizhu = yingshoukuan.getBeizhu();
//				租车费
				String zuchefei = yingshoukuan.getZuchefei();
//				业务费
				String yewufei = yingshoukuan.getYewufei();
				
	//---------------------------------------------------------------------------
	//			创建一行
				Row paraRow = sheet.createRow(i+2);
				
				Cell paraCell0 =paraRow.createCell(0);
				setCellStyle(paraCell0, cellStyle, dingdanhao);
				
				Cell paraCell1 =paraRow.createCell(1);
				setCellStyle(paraCell1, cellStyle, yunshushijian);
				
				Cell paraCell2 =paraRow.createCell(2);
				setCellStyle(paraCell2, cellStyle, chepaihao);
				
				Cell paraCell3 =paraRow.createCell(3);
				setCellStyle(paraCell3, cellStyle, shudi);
				
				Cell paraCell4 =paraRow.createCell(4);
				setCellStyle(paraCell4, cellStyle, fahuodanwei);
	
				Cell paraCell5 =paraRow.createCell(5);
				setCellStyle(paraCell5, cellStyle, huowumingcheng);
				
				Cell paraCell6 =paraRow.createCell(6);
				setCellStyle(paraCell6, cellStyle, shishoudunwei);
				
				Cell paraCell7 =paraRow.createCell(7);
				setCellStyle(paraCell7, cellStyle, shifadunwei);
				
				Cell paraCell8 =paraRow.createCell(8);
				setCellStyle(paraCell8, cellStyle, licheng);
				
				Cell paraCell9 =paraRow.createCell(9);
				setCellStyle(paraCell9, cellStyle, danjia);
				
				Cell paraCell10 =paraRow.createCell(10);
				setCellStyle(paraCell10, cellStyle, daikongtong);
				
				Cell paraCell11 =paraRow.createCell(11);
				setCellStyle(paraCell11, cellStyle, qidian);
				
				Cell paraCell12 =paraRow.createCell(12);
				setCellStyle(paraCell12, cellStyle, zhongdian);
				
				Cell paraCell13 =paraRow.createCell(13);
				setCellStyle(paraCell13, cellStyle, yingshou);
				
				Cell paraCell14 =paraRow.createCell(14);
				setCellStyle(paraCell14, cellStyle, daozhangshijian);
				
				Cell paraCell15 =paraRow.createCell(15);
				setCellStyle(paraCell15, cellStyle, fapiaohao);
				
				Cell paraCell16 =paraRow.createCell(16);
				setCellStyle(paraCell16, cellStyle, kaipiaoshijian);
				
				Cell paraCell17 =paraRow.createCell(17);
				setCellStyle(paraCell17, cellStyle, shuijin);
				
				Cell paraCell18 =paraRow.createCell(18);
				setCellStyle(paraCell18, cellStyle, guanlifei);
				
				Cell paraCell19 =paraRow.createCell(19);
				setCellStyle(paraCell19, cellStyle, daidianfei);
				
				Cell paraCell20 =paraRow.createCell(20);
				setCellStyle(paraCell20, cellStyle, shifuyunfei);
				
				Cell paraCell21 =paraRow.createCell(21);
				setCellStyle(paraCell21, cellStyle, lingkuanshijian);
				
				Cell paraCell22 =paraRow.createCell(22);	
				setCellStyle(paraCell22, cellStyle, qianshou);
				
				Cell paraCell24 =paraRow.createCell(23);	
				setCellStyle(paraCell24, cellStyle, zuchefei);
				
				Cell paraCell25 =paraRow.createCell(24);	
				setCellStyle(paraCell25, cellStyle, yewufei);
				
				Cell paraCell23 =paraRow.createCell(25);	
				setCellStyle(paraCell23, cellStyle, beizhu);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	/**
	 *  判断是否有计算公式
	 */
	public static String getMyCellFormula(Cell cell){
//		初始值为空字符串
		  String value = "";
		   if (cell != null) {
			   switch (cell.getCellType()) {
				   case HSSFCell.CELL_TYPE_FORMULA:
	                   try {
	                     value = String.valueOf(cell.getNumericCellValue());
	                   } catch (Exception e) {
	                     value = String.valueOf(cell.getRichStringCellValue());
	                   }
	                   break;
				   case HSSFCell.CELL_TYPE_NUMERIC:
					   value = String.valueOf(cell.getNumericCellValue());
					   break;
				   case HSSFCell.CELL_TYPE_STRING:
		                value = String.valueOf(cell.getRichStringCellValue());
		                break;
		       }
		   }
		   
		   return value;
	}
	
	/**
	 *  得到日期
	 */
	public static Date getMyCellDate(Cell cell){
		Date date = null;
		String cellStr = String.valueOf(cell);
		
//		判断cell是否是null 或者 cellStr是否空字符串
		if(cell==null || "".equals(cellStr)){
			
		}else{
			try {
				date = cell.getDateCellValue();	
			} catch (Exception e) {
				String dateStr = String.valueOf(cell);
				date = new Date(dateStr);
			}
			System.out.println(date);
		}
		
		return date;
	}
	
}
