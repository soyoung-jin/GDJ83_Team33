const btn = document.getElementsByClassName("btn");


// MyPetList 페이지에서 게임에 사용할 캐릭터를 선택하는 이벤트
for(let b of btn){

    b.addEventListener("click", (e)=>{

        if(e.target.classList.contains("btn")){

            let pet_num = b.getAttribute("data-pet-num");

            fetch("/mypet/select?pet_num=" + pet_num, {
                method:"GET"
            })
            .then((res)=>{return res.text()})
            .then((res)=>{
                if(res>0){
                    alert("지금 바로 게임을 시작해보세요!");
                    location.href="/mypet/mypetList";
                }
            })
        }
    })

}