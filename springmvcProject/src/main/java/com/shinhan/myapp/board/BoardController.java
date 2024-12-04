package com.shinhan.myapp.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shinhan.myapp.vo.MemberDTO;

import lombok.extern.slf4j.Slf4j;
import net.firstzone.util.UploadFileUtils;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService bservice;

	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardlist", bservice.findAll());
		
		return "board/boardList";
	}
	
	@GetMapping("/insert.do")
	public String insertGet() {
		return "board/boardInsert";
	}
		
	@PostMapping("/insert.do")
	public String insertPost(MultipartHttpServletRequest multipart, HttpSession session) {
		HttpServletRequest request = (HttpServletRequest)multipart;
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		
		if(member == null) member = MemberDTO.builder().member_id("guest").build();
		
		String writer = member.getMember_id();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO board = BoardDTO.builder().title(title).content(content).build();
		
		board.setWriter(writer);
		
		
		MultipartFile multipartFile = multipart.getFile("pic");

		String uploadPath = session.getServletContext().getRealPath("./resources/upload");
		String fileName = multipartFile.getOriginalFilename();
		String ymdpath = "";
		String newFileName = "";	
		
		if(!multipartFile.isEmpty()) {
			
			ymdpath = UploadFileUtils.calcPath(uploadPath);
			
			try {
				newFileName = UploadFileUtils.fileUpload(uploadPath, fileName, multipartFile.getBytes(), ymdpath);
				board.setPic(ymdpath + File.separator + newFileName);
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:insert.do";
			}
		}
		
		bservice.insert(board);
		
		return "redirect:list.do";
	}
	
	@GetMapping("/delete.do")
	public String delete(Long bno) {
		bservice.delete(bno);
		
		return "redirect:list.do";
	}
	
	@GetMapping("/detail.do")
	public String detail(Long bno, Model model) {
		log.info("여기 오나?");
		model.addAttribute("board", bservice.findById(bno));
		
		return "board/boardDetail";
	}
	
	@PostMapping("/update.do")
	public String update(BoardDTO board) {
		bservice.update(board);
		
		return "redirect:list.do";
	}
}
