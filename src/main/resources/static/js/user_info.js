const userDataContainer = document.getElementById("userdata");
const calendarButton = document.getElementById("calendarButton");

async function getUserFromEmail()
{
    const url = `http://localhost:8080/getCurrentUserInfo`
    return await fetch(url).then(x => x.json());
}

getUserFromEmail().then(x => {
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

