<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Batch</title>
<link rel="stylesheet" href="/GymManagementApp/css/styles.css" />
</head>
<body>
	<div class="center">
		<div class="navigator">
			<a href="index.html">Home</a> <a href="addBatch.html">Add Batch</a> 
			<a href="addParticipant.jsp">Add Participant</a> 
			<a href="viewBatches.jsp">Batches</a> 
			<a href="viewParticipants.jsp">Participants</a> 
		    <a href="updateBatch.html">Update Batch</a> 
		    <a href="updateParticipant.html">Update Participant</a>
		</div>
		<h1>Add new Batch</h1>
		<form action="BatchController" method="post">
			<ul>
				<li>
					<label for="batchId">Batch ID</label><br>
					<input type="text" id="batchId" name="batchId" placeholder="A1">
				</li>
				<li>
					<label for="day">Day of the Week</label><br>
					<input type="text" id="day" name="day" placeholder="Monday">
				</li>
				<li>
					<label for="time">Start Time</label><br>
					<input type="text" id="time" name="time" placeholder="10:30 am">
				</li>
				<li>
					<input type="submit" value="Submit">
				</li>
			</ul>
			<input type="hidden" id="action" name="action" value="create">
		</form>
	</div>
</body>
</html>