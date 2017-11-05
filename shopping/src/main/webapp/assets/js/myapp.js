$(function() {
//	solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#home').removeClass('active');
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#home').removeClass('active');
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
})