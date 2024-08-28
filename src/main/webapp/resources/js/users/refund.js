const btn = document.getElementsByClassName("btn");


//카카오결제 취소 버튼
for(let b of btn){
    b.addEventListener("click",(e)=>{

        if(confirm("정말로 환불하시겠습니까?")){
            let transaction_num = b.getAttribute("data-transaction-num");
            let item_num = b.getAttribute("data-item-num");
            let transaction_order = b.getAttribute("data-transaction-order");
            let user_id = b.getAttribute("data-user-id");
    
    
    
            if(e.target.classList.contains("btn")){
    
                kakaoDel(transaction_order).then(r=>{
                    if(r == "SUCCEEDED"){
        
                        fetch("/admin/refund",{
                            method:"POST",
                            headers:{"Content-type":"application/x-www-form-urlencoded"},
                            body:"transaction_num=" + transaction_num + "&item_num=" + item_num + "&user_id=" + user_id
                        })
                        .then((res)=>{return res.text()})
                        .then((res)=>{
                            if(res>0){
                                alert("환불 성공!");
                                location.href="/admin/tradeList?user_id=" + user_id;
                            }
                        })
                    }
    
                })
    
            }

        }else{
            return;
        }

        
    });
}



//카카오 결제 취소 함수
async function kakaoDel(transaction_order) {
    uuid = transaction_order ;

    const del = await fetch(`https://api.portone.io/payments/`+uuid+`/cancel`,{ 
        method: 'post',
        headers: {Authorization: `PortOne i68oGkSudVRHtsQtbxZitbS7DPq99kDGH6xS2tz5l9W7w8ppV6xKcAioepMEyyYiW2Ae0mUGZ0NgUguK`, headers: {'Content-Type': 'application/json'}},
        body: '{"reason":"그냥"}'
    },);
    if (!del.ok)
        throw new Error(`del:`+ await del.json());
    const d = await del.json();
    let result = d.cancellation.status

    return result;
}