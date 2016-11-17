	$(function() {
		function initToolbarBootstrapBindings() {
			// 字体
			var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
					'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
					'Times New Roman', 'Verdana'
				],
				fontTarget = $('#font').siblings('.dropdown-menu');
			$.each(fonts, function(idx, fontName) {
				fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
			});

			// 字体颜色
			var foreColor = ['#000', '#fff', '#eeece1', '#1f497d', '#4f81bd', '#c0504d', '#8064a2', '#4bacc6', '#f79646', '#9bbb59'];
			$.each(foreColor, function(i, foreColor) {
				$('#foreColor').append($('<li><a data-edit="foreColor ' + foreColor + '" style="background-color:' + foreColor + '">' + '&nbsp;' + '</a></li>'));
			})

			// 字体背景
			var backColor = ['#000', '#fff', '#eeece1', '#1f497d', '#4f81bd', '#c0504d', '#8064a2', '#4bacc6', '#f79646', '#9bbb59'];
			$.each(backColor, function(i, backColor) {
				$('#backColor').append($('<li><a data-edit="backColor ' + backColor + '" style="background-color:' + backColor + '">' + backColor + '</a></li>'));
			})

			// 背景阴影
			/*			$('#foreColor,#backColor').find('li').children('a').hover(function() {
								var bgc = $(this).css('background-color')
								$(this).css({
									'box-shadow': '0 0 4px 2px ' + bgc
								})
							}, function() {
								$(this).css('box-shadow', 'none')
							})*/

			// 上传图片事件响应
			$('#pictureBtn').on('click', function() {
				$(this).siblings('input').click()
			})

			// 取消行内样式
			$('#removeStyle').click(function() {
				$('#editor').cleanScript()
			})

			// 预览
			$('#preview').click(function() {
				window.open('/resources/preview.jsp')
			})

			$('.hero-unit a[title]').tooltip({
				container: 'body'
			});
			$('.dropdown-menu input').click(function() {
					return false;
				})
				.change(function() {
					$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
				})
				.keydown('esc', function() {
					this.value = '';
					$(this).change();
				});
			$('[data-role=magic-overlay]').each(function() {
				var overlay = $(this),
					target = $(overlay.data('target'));
				overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
			});
			if ("onwebkitspeechchange" in document.createElement("input")) {
				var editorOffset = $('#editor').offset();
				$('#voiceBtn').css('position', 'absolute').offset({
					top: editorOffset.top,
					left: editorOffset.left + $('#editor').innerWidth() - 35
				});
			} else {
				$('#voiceBtn').hide();
			}
		};

		function showErrorAlert(reason, detail) {
			var msg = '';
			if (reason === 'unsupported-file-type') {
				msg = "Unsupported format " + detail;
			} else {
				console.log("error uploading file", reason, detail);
			}
			$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
				'<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
		};
		initToolbarBootstrapBindings();
		$('.textarea').wysiwyg({
			fileUploadError: showErrorAlert,
		});
		window.prettyPrint && prettyPrint();
	});