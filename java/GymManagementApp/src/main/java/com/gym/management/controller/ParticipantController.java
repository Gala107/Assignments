package com.gym.management.controller;

import java.io.IOException;

import com.gym.management.model.Participant;
import com.gym.management.service.ParticipantBatchService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParticipantController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ParticipantBatchService service = new ParticipantBatchService();

		Participant participant = new Participant();
		participant.setName(request.getParameter("name"));
		participant.setEmail(request.getParameter("email"));
		participant.setPhone(request.getParameter("phone"));
		participant.setBatchId(request.getParameter("batch"));
		
		String action = request.getParameter("action");
		if (action.equals("create")) {
			service.createParticipant(participant);
		} else if (action.equals("update")) {
			participant.setId(Integer.parseInt(request.getParameter("participantId")));
			service.updateParticipant(participant);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}
}
