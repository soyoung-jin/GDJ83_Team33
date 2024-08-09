const row = document.getElementsByClassName("row");


// 이거 아직 완성해야됨
// 도중에 하다 말았음
// 장착 버튼 클릭시 무기 장착하는 구조를 만들고자 함
for(let r of row){
    r.addEventListener("click", (e)=>{
        
        console.log("sd");

        if(e.target.classList.contains("btn")){
            console.log("ds");
            alert("성공!");
        }
    })
}