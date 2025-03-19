<script>
	function validateInputs() {
		const email = document.getElementById("email").value;
		const password = document.getElementById("password").value;
		const loginButton = document.getElementById("btnLogin");

		//disable button if either field is empty
		if(email.trim() === "" || password.trim() === "")
		{
			loginButton.disabled = true;
		}
		else
		{
			loginButton.disabled = false;
		}
	}	

</script>