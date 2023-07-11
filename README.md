<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h1>Toffee E-commerce Application</h1>
	<p>This project is an e-commerce website for Toffee, a business that sells sweets like candy, chocolate, toffee, and others. The website provides a catalog of goods that customers can order, and allows them to pay upon delivery or via payment methods like smart wallets. The site also offers gift vouchers, and allows users to view their order history and earn loyalty points when making an order.</p>
	<p>The initial requirements for the project were provided by the client, and were refined through interviews, questions, and other means to ensure full understanding of what the client wants</p>

<h2>Features</h2>
	<ul>
		<li>Registration requires a valid email, a password, and an address. Passwords must follow secure password guidelines, and registration is completed by sending an OTP to the email used, that the user has to enter to complete the registration; otherwise, registration is rejected.</li>
		<li>A logged-in user can shop and add items to his or her shopping cart until s/he is finished, then s/he can check-out. Sealed items are sold by unit and the client chooses up to 50 units of each item in one order. Loose items are sold by kilo, and the buyer can buy any amount up to 50 kilos of an item in one order. Shoppers can also buy gift vouchers to give as a gift to someone. A gift voucher has a unique code and can be redeemed once when making an order to reduce the total price by the value of the voucher.</li>
		<li>A system admin can update catalog with new items, cancel items, or update item info. Admin can view all orders, set loyalty points scheme, suspend a user, and view statistics.</li>
		<li>Buyers can place an order by selecting the items they want and the quantity they want from each item. Then they check-out. They can also view their order history and they can re-order a previous order by clicking "re-corder" button which makes the same exact order with the same exact conditions. When making an order, a buyer earns loyalty points according to the scheme decided by the admin.</li>
		<li>Upon making an order, shoppers have to specify the shipping address; if it is the same address registered on their profile or another address (e.g., in case they are buying a gift from someone). If they are paying upon delivery, they have to enter a valid phone number. An OTP is sent to the mobile number, and the buyer has to enter it to verify the phone number. To pay for an order, a buyer can use one gift voucher or more to pay for their order or part of it, redeem some of the loyalty points to pay for the order or part of it, pay for the order or the remaining amount via payment methods like smart wallets, or pay for the order or the remaining amount with cash upon delivery.</li>
	</ul>

<h2>Architecture</h2>
	<p>The system adopts a layered architecture, with a database layer, a backend layer that has the business logic and presentation or front end layer. Shoppers can access the system via the web or a mobile app. Mobile app should support Android and iPhone. Admin has a dedicated web app that allows him or her to monitor the system and do that tasks assigned to him or her.</p>

<h2>Implementation</h2>
<p>The project was implemented in Java, using design patterns like the Strategy pattern to handle different payment methods and to make the system easily extensible. The code is organized into packages to make it easy to debug and maintain.</p>
<p>We also used OTP validation to increase the security of the system, and save data in files to allow for easy backup and to avoid the additional complexity of setting up a database. Regex (Regular Expressions) were used to validate user input and ensure data consistency and integrity.</p>

<h2>Documentation</h2>
	<p>The project includes a Software Requirements Specification (SRS) that details the required features, use case model, and enriched user stories. The System Navigation Map and System Design Specification (SDS) were also included, which includes UML diagrams, 6 sequence diagrams, state diagram, and C4 diagram. All of these documents are available in the repository for reference.</p>

<h2>Contributors</h2>
	<ul>
		<li>Salma Mamdoh Sabry</li>
		<li>Roaa Talat Mohamed</li>
		<li>Jana Raafat Abd El-Hammed</li>
	
</ul>
</body>
</html>
