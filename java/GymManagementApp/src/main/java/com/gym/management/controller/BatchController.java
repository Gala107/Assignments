package com.gym.management.controller;

import java.io.IOException;

import com.gym.management.model.Batch;
import com.gym.management.service.ParticipantBatchService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParticipantBatchService service = new ParticipantBatchService();

	public BatchController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("delete")) {
//			service.(request.getParameter("batchId"));
//			service.updateBatch(batch);
			// check if there are participants assigned to this batch
			// can delete batch only if there no participants
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Batch batch = new Batch();
		batch.setId(request.getParameter("batchId"));
		batch.setWeekDay(request.getParameter("day"));
		batch.setStartTime(request.getParameter("time"));

		String action = request.getParameter("action");
		if (action.equals("create")) {
			service.createBatch(batch);
		} 
		
//		else if (action.equals("update")) {
//			batch.setId(request.getParameter("batchId"));
//			service.updateBatch(batch);
//		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}
}
