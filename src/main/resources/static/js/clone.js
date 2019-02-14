$('#multiAdd').on('click', function(){

    var div = $('#multi');
    var div2 = $('.clone2')
    div.clone(true).appendTo(div2);
});
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

    var $div_to_toggle = $('#tbl_member');

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



