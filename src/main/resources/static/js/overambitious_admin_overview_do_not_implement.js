window.onload = async function createAdminOverview() {

    let updateVar = localStorage.getItem("updateState");

    const url = "http://localhost:8080/findAllActivities";

    const activity_container = document.getElementById("activity_container")

    const response = await fetch(url);
    const data = await response.json();

    let activityList = data;

    for(let i = 0; i < activityList.length; i++)
    {
        if(i % 2 === 0)
        {
            insertActivityToLeftColumn(activityList[i])


        }
        else
        {
            insertActivityToRightColumn(activityList[i])
        }
    }

    function insertActivityToLeftColumn(activity) {

        const row = document.createElement('div');
        row.setAttribute('class', 'row');
        activity_container.appendChild(row);

        const col_left = document.createElement('div');
        col_left.setAttribute('class', 'col');
        row.appendChild(col_left);

        const h1 = document.createElement('h1');
        h1.setAttribute('class', 'text-danger ms-5');
        if (updateVar === "1"){
            h1.setAttribute('contentEditable', "true");
        }
        h1.setAttribute('id', 'title');
        h1.textContent = activity.title;
        col_left.appendChild(h1);

        const updateButton = document.createElement('button');
        updateButton.setAttribute('class', 'btn btn-primary ms-5');
        updateButton.setAttribute('id', 'updateButton');
        updateButton.innerHTML = "Update";
        col_left.appendChild(updateButton);

        const saveUpdateButton = document.createElement("button");
        saveUpdateButton.setAttribute('class', 'btn btn-success ms-5');
        saveUpdateButton.setAttribute('id', 'saveUpdateButton');
        saveUpdateButton.innerHTML = "Save";
        col_left.appendChild(saveUpdateButton);

        const deleteButton = document.createElement('button');
        deleteButton.setAttribute('class', 'btn btn-warning ms-5');
        deleteButton.setAttribute('id', 'deleteButton');
        deleteButton.innerHTML = "Delete";
        col_left.appendChild(deleteButton);

        const p = document.createElement('p');
        p.setAttribute('class', 'text-danger ms-5')
        if (updateVar === "1") {
            p.setAttribute('contentEditable', 'true');
        }
        p.setAttribute('id', 'description');
        p.textContent = activity.description;
        col_left.appendChild(p);

        const p_price = document.createElement('p');
        p_price.setAttribute('class', 'text-danger ms-5 fw-bold');
        if (updateVar === "1") {
            p_price.setAttribute('contentEditable', 'true');
        }
        p_price.setAttribute('id', 'p_price');
        p_price.textContent = "Price: " + activity.price;
        col_left.appendChild(p_price);

        const p_height = document.createElement('p');
        p_height.setAttribute('class', 'text-danger ms-5 fw-bold');
        if (updateVar === "1") {
            p_height.setAttribute('contentEditable', 'true');
        }
        p_height.setAttribute('id', 'p_height');
        p_height.textContent = "Minimum height: " + activity.minHeight;
        col_left.appendChild(p_height);

        const col_right = document.createElement('div');
        col_right.setAttribute('class', 'col text-center');
        row.appendChild(col_right);

        const img = document.createElement('img');
        img.setAttribute('class', 'h-100 w-50 p-4');
        img.setAttribute('src', activity.imageLink);
        col_right.appendChild(img);
    }

    function insertActivityToRightColumn(activity) {
        const row = document.createElement('div');
        row.setAttribute('class', 'row');
        activity_container.appendChild(row);

        const col_left = document.createElement('div');
        col_left.setAttribute('class', 'col text-center');
        row.appendChild(col_left);

        const col_right = document.createElement('div');
        col_right.setAttribute('class', 'col');
        row.appendChild(col_right);

        const h1 = document.createElement('h1');
        h1.setAttribute('class', 'text-danger' + ' ms-5');
        if (updateVar === "1") {
            h1.setAttribute('contentEditable', 'true');
        }
        h1.setAttribute('id', 'title');
        h1.textContent = activity.title;
        col_right.appendChild(h1);

        const updateButton = document.createElement('button');
        updateButton.setAttribute('class', 'btn btn-primary ms-5');
        updateButton.setAttribute('id', 'updateButton');
        updateButton.innerHTML = "Update";
        col_right.appendChild(updateButton);

        const saveUpdateButton = document.createElement("button");
        saveUpdateButton.setAttribute('class', 'btn btn-success ms-5');
        saveUpdateButton.setAttribute('id', 'saveUpdateButton');
        saveUpdateButton.innerHTML = "Save";
        col_right.appendChild(saveUpdateButton);

        const deleteButton = document.createElement('button');
        deleteButton.setAttribute('class', 'btn btn-warning ms-5');
        deleteButton.setAttribute('id', 'deleteButton');
        deleteButton.innerHTML = "Delete";
        col_right.appendChild(deleteButton);

        const p = document.createElement('p');
        p.setAttribute('class', 'text-danger ms-5')
        if (updateVar === "1") {
            p.setAttribute('contentEditable', 'true');
        }
        p.setAttribute('id', 'description');
        p.textContent = activity.description;
        col_right.appendChild(p);

        const p_price = document.createElement('p');
        p_price.setAttribute('class', 'text-danger ms-5 fw-bold');
        if (updateVar === "1") {
            p_price.setAttribute('contentEditable', 'true');
        }
        p_price.setAttribute('id', 'p_price');
        p_price.textContent = "Price: " + activity.price;
        col_right.appendChild(p_price);

        const p_height = document.createElement('p');
        p_height.setAttribute('class', 'text-danger ms-5 fw-bold');
        if (updateVar === "1") {
            p_height.setAttribute('contentEditable', 'true');
        }
        p_height.setAttribute('id', 'p_height');
        p_height.textContent = "Minimum height: " + activity.minHeight;
        col_right.appendChild(p_height);

        const img = document.createElement('img');
        img.setAttribute('class', 'h-100 w-50 p-4');
        img.setAttribute('src', activity.imageLink);
        col_left.appendChild(img);
    }

    document.querySelectorAll('#updateButton').forEach(updateButton => {
        updateButton.addEventListener('click', changeUpdateStateToTrue);
    });

    function changeUpdateStateToTrue() {
        localStorage.setItem("updateState", "1");
        location.reload();
    }

    let updatedActivity = {
        "activity_id":"",
        "description":"",
        "equipment":"",
        "imageLink":"",
        "minAge":"",
        "minHeight":"",
        "price":"",
        "title":""
    }

    console.log(updatedActivity);

    /*const updatedActivity = {
        "activity_id":activity.activity_id,
        "description":document.getElementById("description").innerText,
        "equipment":document.getElementById("equipment").innerText,
        "imageLink":activity.imageLink,
        "minAge":document.getElementById("minAge").innerText,
        "minHeight":document.getElementById("minHeight").innerText,
        "price":document.getElementById("price").innerText,
        "title":document.getElementById("title").innerText
    }*/

    document.querySelectorAll('#saveUpdateButton').forEach(saveUpdateButton => {
        saveUpdateButton.addEventListener('click', x =>  {
            console.log(x);
            updateDB(updatedActivity);
            changeUpdateStateToFalse();
        });
    });


    function changeUpdateStateToFalse() {
        localStorage.setItem("updateState", "0");
        location.reload();
    }
}

function updateDB(activity) {
    const url = "http://localhost:8080/updateActivity";

    const activityStringified = JSON.stringify(activity);

    let putObject = {
        headers: {"contentType": "application/json"},
        method: "PUT",
        body: activityStringified
    }
    console.log(activity);
    console.log(putObject);
    fetch(url, putObject);
}