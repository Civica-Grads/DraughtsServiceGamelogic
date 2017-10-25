package com.civica.grads.boardgames.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.civica.grads.boardgames.exceptions.GameException;
import com.civica.grads.boardgames.exceptions.MoveException;
import com.civica.grads.boardgames.model.Board;
import com.civica.grads.boardgames.model.Position;
import com.civica.grads.boardgames.model.draughts.MakeMoveLogicDraughts;

@RestController
public class DraughtsServiceGamelogic {

	@Autowired
	private Board board;

    @RequestMapping("/validate")
    boolean checkMoveIsValid(@RequestParam int startPosX, 
            @RequestParam                   int startPosY , 
            @RequestParam                int newPosX, 
            @RequestParam                int newPosY)
    {
        return checkMoveIsValid(new Position(startPosX,startPosY), // X
                                new Position(newPosX,newPosY)      // Y
                                );
    }
	
    @RequestMapping("/isValid")
	boolean checkMoveIsValid(Position startPos , Position newPos)
	{
        MakeMoveLogicDraughts toTest = new MakeMoveLogicDraughts(board , startPos, newPos);
        
        try {
            toTest.checkForValidMove();
            return true;
        } catch (MoveException ex) {
            
            ex.printStackTrace();
            
            return false ;
        }        
	}
	
	
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