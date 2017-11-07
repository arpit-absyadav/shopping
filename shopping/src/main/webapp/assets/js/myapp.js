$(function() {
//	solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#home').removeClass('active');
		$('#about').addClass('active');
		$('#about').css("color", "blue")
		break;
	case 'Contact Us':
		$('#home').removeClass('active');
		$('#contact').addClass('active');
		$('#contact').css("color", "blue")
		break;
	default:
		$('#home').addClass('active');
		break;
	}
})