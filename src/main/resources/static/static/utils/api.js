
function getEmployeeById(emp_id, id){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/bank-employee-old/'+emp_id,
        success: function (res){
            switch (id){
                case 1: seeInfo(res.emp_id);break;
                case 2: seeInfo(res.number);break;
                case 3: seeInfo(res.code_unique);break;
                case 4: seeInfo(res.bank_block);break;
                case 5: seeInfo(res.bank_direct);break;
                case 6: seeInfo(res.bank_dep);break;
                case 7: seeInfo(res.bank_dep_insade);break;
                case 8: seeInfo(res.emp_position);break;
                case 9: seeInfo(res.emp_level);break;
                case 10: seeInfo(res.emp_manager);break;
                case 11: seeInfo(res.sub_employee);break;
                case 12: seeInfo(res.level_require);break;
                case 13: seeInfo(res.emp_skill);break;
                case 14: seeInfo(res.main_obligation);break;
                case 15: seeInfo(res.func_desc);break;
                case 16: seeInfo(res.responsibility);break;
                case 17: seeInfo(res.emp_law);break;
                case 18: seeInfo(res.conf_direct_man1);break;
                case 19: seeInfo(res.conf_direct_man2);break;
                case 20: seeInfo(res.conf_direct_man3);break;
                case 21: seeInfo(res.conf_direct_man4);break;
                case 22: seeInfo(res.fullname);break;
                default: seeInfo("");
            }
        }
    })
}

function seeInfo(str){
    document.getElementById("see-data-item").innerHTML='';
    seeModal.style.display="block";
    if (str!==''){
        document.getElementById("see-data-item").innerHTML=str;
    }
}
