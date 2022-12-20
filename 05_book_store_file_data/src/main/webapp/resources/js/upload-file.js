var upload = document.getElementById('uploadBtn');
var fileInput = document.getElementById('uploadInput');
var formUpload = document.getElementById('uploadForm');
var messageUpload = document.getElementById('messageModal');

document.addEventListener('DOMContentLoaded', () => {

	upload.addEventListener('click', () => {
		fileInput.click();
	});
	fileInput.addEventListener('change', () => {
		formUpload.submit();
	});

	//Show File Upload Message Dialog


	if (messageUpload) {
		var modal = new bootstrap.Modal(messageUpload);
		modal.show();
	}

});