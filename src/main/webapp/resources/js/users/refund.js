const btn = document.getElementsByClassName("btn");


//카카오결제 취소 버튼
for(let b of btn){
    b.addEventListener("click",(e)=>{

        if(confirm("정말로 환불하시겠습니까?")){
            let transaction_num = b.getAttribute("data-transaction-num");
            let item_num = b.getAttribute("data-item-num");
            let transaction_order = b.getAttribute("data-transaction-order");
            let user_id = b.getAttribute("data-user-id");
            let transaction_amount= b.getAttribute("data-transaction-amount");
    
    
    
            if(e.target.classList.contains("btn")){
    
                kakaoDel(transaction_order,transaction_amount).then(r=>{
                    if(r == "SUCCEEDED"){
                        
                        // let form = new FormData()
                        // form.append("transaction_num", transaction_num)
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
async function kakaoDel(transaction_order,transaction_amount) {
    uuid = transaction_order ;

    let trsamount = 0;
    trsamount = transaction_amount;


    const del = await fetch(`https://api.portone.io/payments/`+uuid+`/cancel`,{ 
        method: 'post',
        headers: {Authorization: ``, 'Content-Type': 'application/json'},
        body: `{"amount":${trsamount},"reason":"reason"}`
    },);
    if (!del.ok)
        throw new Error(`del:`+ await del.json());
    const d = await del.json();
    let result = d.cancellation.status

    return result;
}