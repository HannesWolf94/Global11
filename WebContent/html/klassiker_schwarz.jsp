<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jspf" %>
<link rel="stylesheet" type="text/css" href="../style/style.css">
	<form method="POST" action="../WarenkorbServlet">
		<header>
			<h1>Puma Klassiker schwarz</h1>
		</header>
		<main> <img src="../img/PumaKlassikerSchwarz.jpg" width="213"
			height="162" alt="Klassiker schwarz">
		<table>
			<tr>
				<td>
					<h3>Farbe</h3> <select name="farbe">
						<option>schwarz</option>
				</select>
				</td>
				<td>

					<h3>Größe</h3> <select name="groesse">
						<option>39</option>
						<option>40</option>
						<option>41</option>
						<option>42</option>
						<option>43</option>
						<option>44</option>
						<option>45</option>
						<option>46</option>
						<option>47</option>
				</select>
				</td>

				<td>
					<h3>Anzahl</h3> <select name="anzahl">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
				</select>
				</td>
			</tr>

			<tr>
				<td colspan="3">
					<button type="submit" name="action" value="klassiker_schwarz">In den
						Warenkorb</button>
				</td>
			</tr>
		</table>
		</main>
	</form>
<%@ include file="footer.jspf" %>