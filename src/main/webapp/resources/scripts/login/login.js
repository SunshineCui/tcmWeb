// add by zbq on Date 2016/03/28

var Login = function() {};

Login.prototype = {
	//提交时验证
	submit: function(el, even, formID) {
		var _self = this;
		$(el).on(even, function() {
			var account = $('.account').val(),
				pwd = $('.pwd').val(),
				yzm = $('.yzm').val()
			if (!(account && account.length)) {
				_self.show('.showMsg', '请输入用户名！')
				return false;
			}
			if (!(pwd && pwd.length)) {
				_self.show('.showMsg', '请输入密码！')
				return false;
			}
			if (!(yzm && yzm.length)) {
				_self.show('.showMsg', '请输入验证码！')
				return false;
			};
				$("#"+formID).submit();
		})
	},
	show: function(el, msg) {
		$(el).text(msg);
	}
}