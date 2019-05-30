function alert_advance_info(info){
	Lobibox.notify('info', {msg:info});
	/*Lobibox.notify('info', {
        size: 'mini',
        title: 'Lorem ipsum',
        msg: info
    });*/
}
function alert_advance_warnning(info){
	Lobibox.notify('warning', {msg:info});	
}
function alert_advance_error(info){
	Lobibox.notify('error', {msg:info});
}
function alert_advance_success(info){
	Lobibox.notify('success', {msg:info});
}