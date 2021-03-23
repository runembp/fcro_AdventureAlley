const userEmail = window.location.href.substring(31);
const userDataContainer = document.getElementById("userdata");

async function getUserFromEmail(email)
{
    const url = `http://localhost:8080/getUserByEmail/${email}`
    return await fetch(url).then(x => x.json());
}

getUserFromEmail(userEmail).then(x => {
    populateFields(x)
});

async function populateFields(user) {

    let emailElement = document.createElement("p");
    emailElement.textContent = "Email: " + user.email;
    userDataContainer.appendChild(emailElement);

    let nameElement = document.createElement("p");
    nameElement.textContent = "Navn :" + user.firstName + " " + user.lastName;
    userDataContainer.appendChild(nameElement);

    let birthdateElement = document.createElement("p");
    birthdateElement.textContent = "Fødselsdato: " + user.dateOfBirth;
    userDataContainer.appendChild(birthdateElement);

    let heightElement = document.createElement("p");
    heightElement.textContent = "Højde: " + user.height;
    userDataContainer.appendChild(heightElement);
}




