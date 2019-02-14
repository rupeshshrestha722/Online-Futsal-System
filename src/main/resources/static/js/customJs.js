//
// function membervisible(){
//     var checkbox = document.getElementById('memberExist');
//     var detail = document.getElementById('tbl_member');
//     detail.style.display="none";
//     if(checkbox.checked()==true){
//         detail.style.display="block";
//     }else {s
//         detail.style.display="none";
//     }
// }

function toggle_dom_element(dom, state) {
    if (state === 'hide') {
        dom.hide(500);
        dom.find('input').each(function () {
            $(this).removeAttr('required');
        });
    } else if (state === 'show') {
        dom.show(500);
        dom.find('input').each(function () {
            $(this).attr('required', 'required');
        });

        $('.optional').removeAttr('required');
    }

}


$('#memberExist').on('click', function () {

    var $div_to_toggle = $('#memberDetail');

    if ($(this).prop('checked')) {
        toggle_dom_element($div_to_toggle, 'show');

    } else {
        //Also clear the field after hiding
        $div_to_toggle.find('input').each(function () {
            $(this).val('');
        });
        toggle_dom_element($div_to_toggle, 'hide');
    }
});




$(document).ready(function () {
    new Date($.now());

    var dateObj = new Date();
    var strDate = dateObj.getFullYear() + "-" + dateObj.getMonth() + "-" + dateObj.getDate();


    $('#np-date').val(strDate);


})
$('#btnAdd').on('click', function () {
    var tblBody = $('#tbl_member');
    var row_to_clone = tblBody.find('tr').last();
    var row_name = row_to_clone.find('input, select').attr('name');

    //Find the position- its in between two square brackets
    var braces_start = row_name.indexOf('[');
    var braces_end = row_name.indexOf(']');
    var list_position = row_name.slice(braces_start + 1, braces_end);
    //Clone a textfield and append it to the table
    //clone() has parameters to register events
    var row_cloned = row_to_clone.clone(true, true).appendTo(tblBody);

    //Clear the new textfield created
    row_cloned.find('input').val('');
    //Set new name for each added rows
    var new_list_position = parseInt(list_position) + parseInt("1");

    row_cloned.find('td').each(function () {
        var name = $(this).find('input, select').attr('name');
        $(this).find('input, select').attr('name', name.replace('[' + list_position + ']', '[' + new_list_position + ']'));
    });
});

$('#btnSub').on('click', function () {
    var tblBody = $('#tbl_member');
    var row_to_clone = tblBody.find('tr').last();
    //One of the <tr> contains <th> itself.
    if (tblBody.find('tr').siblings().length > 1)
        row_to_clone.remove();
});

// Horizontally Scroll
$(document).ready(function () {
    $('#dataTable').DataTable();
});

$('.ageChar').attr('pattern', '^[0-3]$');//Starts optionally w + followed by numbers
$('.ageChar').attr('title', 'Number cannot be more than 3');

$('.ageChar').attr('pattern', '^[0-5]$');//Starts optionally w + followed by numbers
$('.ageChar').attr('title', 'Number cannot be more than 5');
$("#datetimepicker2").datepicker({
    dateFormat: "mm/dd/yy",
    minDate: new Date()
});