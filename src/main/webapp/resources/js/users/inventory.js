const btn = document.getElementsByClassName("btn");
const del = document.getElementsByClassName("del");


// 아이템 장착 버튼 클릭시, 현재 사용중인 캐릭터의 추가 능력치가 업데이트되도록 하는 이벤트
for(let b of btn){
    b.addEventListener("click", (e)=>{

        if(e.target.classList.contains("btn")){
            
            let item_num = b.getAttribute("data-item-num");
            let item_hp = b.getAttribute("data-item-hp");
            let item_atk = b.getAttribute("data-item-atk");
            let item_dod = b.getAttribute("data-item-dod");
            let inventory_num = b.getAttribute("data-inventory-num");


            fetch("/users/equipItem?item_num=" + item_num + "&item_hp=" + item_hp
                + "&item_atk=" + item_atk + "&item_dod=" + item_dod + "&inventory_num=" + inventory_num, {
                method:"GET"
            })
            .then((res)=>{return res.text()})
            .then((res)=>{
                if(res > 0){
                    alert("파워 업!!");
                    location.href="/users/inventory";
                    // 비동기식으로 화면 전환 방법을 몰라서 주소창 다시 호출하는 방법을 사용
                }
            })
        }
    })
}

// 아이템 해제 버튼 클릭시, 현재 사용중인 캐릭터의 추가 능력치를 null로 업데이트 하는 이벤트
for(let d of del){
    d.addEventListener("click", (e)=>{

        if(e.target.classList.contains("del")){

            fetch("/users/takeOffItem", {
                    method:"GET"
                })
                .then((res)=>{return res.text()})
                .then((res)=>{
                    if(res > 0){
                        alert("해제!!")
                        location.href="/users/inventory";
                    }
                })
        }
    })
}