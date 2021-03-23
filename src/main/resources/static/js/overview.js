let activityList;

window.onload = async function createOverview() {
    const url = "http://localhost:8080/findAllActivities";

    const activity_container = document.getElementById("activity_container")

    const response = await fetch(url);
    const data = await response.json();

    activityList = data;

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

    function insertActivityToLeftColumn(activity)
    {
        const row = document.createElement('div');
        row.setAttribute('class', 'row');
        activity_container.appendChild(row);

        const col_left = document.createElement('div');
        col_left.setAttribute('class', 'col');
        row.appendChild(col_left);

        const h1 = document.createElement('h1');
        h1.setAttribute('class', 'text-danger' + ' ms-5');
        h1.textContent = activity.title;
        col_left.appendChild(h1);

        const p = document.createElement('p');
        p.setAttribute('class', 'text-danger ms-5')
        p.textContent = activity.description;
        col_left.appendChild(p);

        const p_price = document.createElement('p');
        p_price.setAttribute('class', 'text-danger ms-5 fw-bold');
        p_price.textContent = "Price: " + activity.price;
        col_left.appendChild(p_price);

        const p_height = document.createElement('p');
        p_height.setAttribute('class', 'text-danger ms-5 fw-bold');
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
        h1.textContent = activity.title;
        col_right.appendChild(h1);

        const p = document.createElement('p');
        p.setAttribute('class', 'text-danger ms-5')
        p.textContent = activity.description;
        col_right.appendChild(p);

        const p_price = document.createElement('p');
        p_price.setAttribute('class', 'text-danger ms-5 fw-bold');
        p_price.textContent = "Price: " + activity.price;
        col_right.appendChild(p_price);

        const p_height = document.createElement('p');
        p_height.setAttribute('class', 'text-danger ms-5 fw-bold');
        p_height.textContent = "Minimum height: " + activity.minHeight;
        col_right.appendChild(p_height);

        const img = document.createElement('img');
        img.setAttribute('class', 'h-100 w-50 p-4');
        img.setAttribute('src', activity.imageLink);
        col_left.appendChild(img);
    }
}