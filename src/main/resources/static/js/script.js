window.onload = async function (){
    await fetchJokes();
    console.log("onload() ended")

    let addJokeButton = document.querySelector("button");
    addJokeButton.onclick = addJoke;
};

async function addJoke(event){
    event.preventDefault();
    console.log( "button clicked");


    let newJoke = {
        jokeText: document.querySelector("input#joke-text").value
    }

    let uri = "http://localhost:8080/jokes";
    let config = {
        method: "post",
        headers:
            {
                "Content-Type":"application/json"
            },
        body:JSON.stringify(newJoke)
    };

    let response = await fetch(uri,config);
    let json = await response.json();


    let section = document.querySelector("#jokes-list");
    addSingleJoke(newJoke,section);

    console.log("Joke add" ,json);

}

async function fetchJokes() {
    let uri = "http://localhost:8080/jokes";
    let config = {
        method: "get"
    };


    let response = await fetch(uri, config);
    let json = await response.json();
    addCards(json);
}
    function addCards(jokesArray){
    let section = document.querySelector("#jokes-list");
        for (let i = 0; i < jokesArray.length; i++)
        {
            let joke= jokesArray[i]
             addSingleJoke(joke,section);
            //assemble the html for a jok eusing a string-template literal
            // let html =
            //     `<div class="card">
            //         <h1>Joke #<span id="joke-id"> ${joke.id}</span></h1>
            //         <p id="joke-body"> ${joke.jokeText}</p>
            //
            //     </div>`;




        }
    }

    function addSingleJoke(joke,section){
        let div = document.createElement("div");
        let h1 = document.createElement("h1");
        let p = document.createElement("p");

        div.appendChild(h1);
        div.appendChild(p);

        h1.textContent = `Joke # ${joke.id}`;
        p.textContent = `${joke.jokeText}`;
        div.className ="card";

        section.appendChild(div);
    }


