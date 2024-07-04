
$(document).ready(function (){
    getBlockAll("all");
    getDirectAll("all");
    getDepartAll("all");
});

function blockListChange(){
    getDirectAll("change");
}

function directListChange(){
    getDepartAll("change");
}

function getBlockAll(type){
    $.ajax({
        type: 'GET',
        url: host_ + '/bank-block/block-all',
        success: function (res) {
            let blocks = '';
            res.forEach((item)=>{
                if (type=="all"){
                    blocks = blocks + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                }
            })
            document.getElementById("block_id").innerHTML=blocks;
        }
    });
}

function getDirectAll(type){
    let id_ = document.getElementById("block_id").value;
    $.ajax({
        type: 'GET',
        url: host_ + '/bank-direct/direct-all',
        success: function (res) {
            let direct = '';
            let id_direct = null;
            let step = 0;
            res.forEach((item)=>{
                if (type=="all") {
                    direct = direct + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                }
                if (type=="change"){
                    if (id_==item.block_id){
                        direct = direct + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                        if (step==0){
                            id_direct = item.id;
                        }
                        step = step + 1;
                    }
                }
            })
            document.getElementById("direct_id").innerHTML=direct;
            if (type=="change"){
                getDepartAll1("change", id_direct);
            }
        }
    });
}

function getDepartAll(type){
    let id_ = document.getElementById("direct_id").value;
    $.ajax({
        type: 'GET',
        url: host_ + '/bank-depart/depart-all',
        success: function (res) {
            let depart = '';
            let step = 0;
            res.forEach((item)=>{
                if (type=="all") {
                    depart = depart + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                }
                if (type=="change"){
                    if (id_==item.directorate_id){
                        depart = depart + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                        step = step + 1;
                    }
                }
            })
            if(step === 0){
                depart = depart + '<option value=0>В дирекции нет департамент</option>';
            }
            document.getElementById("depart_id").innerHTML=depart;
        }
    });
}

function getDepartAll1(type, id_1){
    $.ajax({
        type: 'GET',
        url: host_ + '/bank-depart/depart-all',
        success: function (res) {
            let depart = '';
            let step = 0;
            res.forEach((item)=>{
                if (type=="all") {
                    depart = depart + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                }
                if (type=="change"){
                    if (id_1==item.directorate_id){
                        depart = depart + '<option value="' + item.id + '">' + item.code + " - " + item.name_en + '</option>';
                        step = step + 1;
                    }
                }
            })
            if(step === 0){
                depart = depart + '<option value=0>В дирекции нет департамент</option>';
            }
            document.getElementById("depart_id").innerHTML=depart;
        }
    });
}
