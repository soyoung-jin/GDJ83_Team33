/**
 * 
 */
console.log("hi")
const ranklike = document.getElementById("ranklike");

const pet_pop = document.getElementById("pet_pop");
const pop_btn = document.getElementsByClassName("pop_btn");



for(let b of pop_btn){
    b.addEventListener("click", function(e){

        console.log(e.target);
        if(e.target.classList.contains("pop_btn")){
            let pet_num = b.getAttribute("data-pet-num");

            fetch("./clickLike?pet_num=" + pet_num,{
                 method:"GET"
            })
            .then(r => {return r.text()})
            .then((r)=>{
                if(r>0){
                    location.href="/rank/rankList";

                }


    })
        }
    })
}

