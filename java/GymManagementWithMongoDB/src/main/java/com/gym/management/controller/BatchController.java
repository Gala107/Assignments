package com.gym.management.controller;

import java.io.IOException;

import com.gym.management.model.Batch;
import com.gym.management.service.BatchService;
import com.gym.management.service.ParticipantService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BatchService service = new BatchService();
	ParticipantService participantService = new ParticipantService();

	public BatchController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("delete")) {
			doDelete(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("create")) {
			service.createBatch(populateBatch(request));

			RequestDispatcher dispatcher = request.getRequestDispatcher("viewBatches.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("update")) {
			doPut(request, response);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int batchId = Integer.parseInt(request.getParameter("batchId"));

		int result = service.deleteBatch(batchId);
		if(result == 5) {
			request.setAttribute("message", "Batch " + batchId + " cannot be deleted. There are Participants assigned to this Batch.");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewBatches.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service.updateBatch(populateBatch(request));

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewBatches.jsp");
		dispatcher.forward(request, response);
	}

	private Batch populateBatch(HttpServletRequest request) {		
		Batch batch = new Batch();
		batch.setId(Integer.parseInt(request.getParameter("batchId")));
		batch.setWeekDay(request.getParameter("day"));
		batch.setStartTime(request.getParameter("time"));
		return batch;
	}
}
