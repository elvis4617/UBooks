package elvis.ubooks.book.admin.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import elvis.ubooks.book.domain.Book;
import elvis.ubooks.book.service.BookService;
import elvis.ubooks.category.service.CategoryService;


@WebServlet("/admin/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Book book = new Book();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(100*1024);
		sfu.setSizeMax(500*1024);
		
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> list = sfu.parseRequest(request);
			
			for(FileItem item : list){
				if(item.isFormField()){
					if(item.getFieldName().equals("bname"))
						book.setBname(item.getString());
					else if(item.getFieldName().equals("price"))
						book.setPrice(Double.valueOf(item.getString()));
					else if(item.getFieldName().equals("author"))
						book.setAuthor(item.getString());
					else if(item.getFieldName().equals("cid"))
						book.setCategory(categoryService.loadCategorybyCid(item.getString()));
				}else{
					//得到文件保存的路径
					String root = this.getServletContext().getRealPath("/book_img");
					
					/*
					 * 生存两层目录
					 * 得到hashcode
					 * 转化成16进制
					 * 获取前两个字符来生成目录
					 */
					String filename = item.getName();
					//处理文件名的绝对路径问题
					int index = filename.lastIndexOf("\\");
					if(index != -1){
						filename = filename.substring(index+1);
					}
					//处理文件重名问题
					String savename = CommonUtils.uuid() + "_" + filename;
					
					//得到hashcode
					int hashcode = filename.hashCode();
					String hex = Integer.toHexString(hashcode);
					
					//获取hex的前两个字母与root连接在一起生成完整的路径
					File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
					
					//创建目录链
					dirFile.mkdirs();
					
					//创建目标文件
					File destFile = new File(dirFile,savename);
					
					//保存
					book.setImage("book_img" + "/" + hex.charAt(0) + "/" + hex.charAt(1)+ "/" + savename);
					item.write(destFile);
				}
			}
			book.setBid(CommonUtils.uuid());
			book.setDel(false);
			bookService.upload(book);
			request.setAttribute("msg", "add book successfullly");
			request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
		}catch(FileUploadException e){
			if(e instanceof FileUploadBase.FileSizeLimitExceededException)
				request.setAttribute("msg", "file size exceed 100kb");
			else if(e instanceof FileUploadBase.SizeLimitExceededException)
				request.setAttribute("msg", "form size exceed 500kb");
			request.setAttribute("msg", "fail to add");
			request.setAttribute("book", book);
			request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
