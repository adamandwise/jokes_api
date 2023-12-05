//wait until the pageloads
window.onload = function(){
    //create objects to make aGET request
    let uri  = "http://localhost:8080/jokes";
    let params ={
        method:"get"
    };

    fetch(uri,params)
        .then(function(response){
        return response.json();
    })
        .then(function (data){
            showJokes(data);
        });


};

function showJokes(data)
{

    // acceess  the list   in our html
     let         jokesList = document.getElementById("jokes-list");
    /*
        <section>
            <h2></h2>
            <p></p>
        </section>
         */
     for(let i = 0 ; i < data.length; i++)
    {
        let joke = data[i];


        let section = document.createElement("section");
        let h2 = document.createElement("h2");
        let paragraph = document.createElement("p");

        //add contents
        h2.innerText ="jokes #" +joke.id;
        paragraph.innerText = joke.jokeText;

        // connect them
        section.appendChild(h2);
        section.appendChild(document.createElement("hr"));
        section.appendChild(paragraph);

        //add the list item to the list
        jokesList.appendChild(section);
    }

}