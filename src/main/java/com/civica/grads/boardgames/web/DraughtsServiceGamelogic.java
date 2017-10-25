package com.civica.grads.boardgames.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.model.Board;

@Controller
public class DraughtsServiceGamelogic {

	@Autowired
	private Board board;

	@RequestMapping("/help")
	@ResponseBody
	String renderBoard() throws GameException {
		//
		// StringBufferBoardRenderer boardRender = new
		// StringBufferBoardRenderer();
		// boardRender.render(board);

		String help = "BRUCE PLEASE HELP";

		String pageHtml = String.format("<html><body><pre>%s</pre></body></html>", help);

		return pageHtml;
	}

}