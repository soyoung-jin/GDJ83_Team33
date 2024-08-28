/**
 * 
 */
console.log("hi")
const ranklike = document.getElementById("ranklike");

const pet_pop = document.getElementById("pet_pop");
const pop_btn = document.getElementsByClassName("pop_btn");

const modalContents = document.getElementById("modalContents");


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

// 랭킹 리스트 모달 요청
function getPetDTO(pet_num) {
    fetch("rankPlayModal?pet_num="+pet_num,{
        method:"get"
    }).then(r=>r.text())
    .then(r=>{
        modalContents.innerHTML=r

        modalBtn.click()
    }).catch(()=>{
        alert("오류!")
    })
}

