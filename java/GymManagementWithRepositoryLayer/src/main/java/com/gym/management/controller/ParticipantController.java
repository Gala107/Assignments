package com.gym.management.controller;

import java.io.IOException;
import java.util.Arrays;

import com.gym.management.model.Participant;
import com.gym.management.service.ParticipantService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParticipantService service = new ParticipantService();

	public ParticipantController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("delete")) {
			doDelete(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("create")) {
			service.createParticipant(populateParticipant(request));

			RequestDispatcher dispatcher = request.getRequestDispatcher("viewParticipants.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("update")) {
			doPut(request, response);
		} else if (action.equals("updateParticipants")) {
			doPatch(request, response);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int participantId = Integer.parseInt(request.getParameter("participantId"));
		service.deleteParticipant(participantId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewParticipants.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service.updateParticipant(populateParticipant(request));

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewParticipants.jsp");
		dispatcher.forward(request, response);
	}

	public void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchId = request.getParameter("batch");
		String[] participantIds = request.getParameterValues("participantId");
		if (participantIds != null) {
			int[] ids = Arrays.stream(participantIds).mapToInt(Integer::parseInt).toArray();
			service.updateParticipantsBatch(ids, batchId);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewParticipants.jsp");
		dispatcher.forward(request, response);
	}

	private Participant populateParticipant(HttpServletRequest request) {
		Participant participant = new Participant();

		String id = request.getParameter("participantId");
		if (id != null) {
			participant.setId(Integer.parseInt(id));
		}
		participant.setName(request.getParameter("name"));
		participant.setEmail(request.getParameter("email"));
		participant.setPhone(request.getParameter("phone"));
		participant.setBatchId(request.getParameter("batch"));
		return participant;
	}
}
