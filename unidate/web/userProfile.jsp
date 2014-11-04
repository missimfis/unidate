<!doctype html>
<html lang="en-US">
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>User Profile</title>
  <meta name="author" content="Thomas Huynh">
  <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>

<body>
  <div id="topbar">

  </div>
  
  <div id="w">
    <div id="content" class="clearfix">
      <div id="userphoto"><img src="images/avatar.png" alt="default avatar"></div>
      <h1>Benutzerprofil</h1>

      <nav id="profiletabs">
        <ul class="clearfix">
          <li><a href="#bio" class="sel">Biographie</a></li>
          <li><a href="#activity">Aktivit&aumlt</a></li>
          <li><a href="#friends">Partner</a></li>
          <li><a href="#settings">Einstellungen</a></li>
        </ul>
      </nav>
      
      <section id="bio">
        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, 
		sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum 
		dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, 
		sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
      </section>
      
      <section id="activity" class="hidden">
        <p>Neueste Aktionen:</p>
        
        <p class="activity">@10:15PM - Submitted a news article</p>
        
        <p class="activity">@9:50PM - Submitted a news article</p>
        
        <p class="activity">@8:15PM - Posted a comment</p>
        
        <p class="activity">@4:30PM - Added <strong>someusername</strong> as a friend</p>
        
        <p class="activity">@12:30PM - Submitted a news article</p>
      </section>
      
      <section id="friends" class="hidden">
        <p>Friends list:</p>
        
        <ul id="friendslist" class="clearfix">
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> Username</a></li>
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> SomeGuy123</a></li>
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> PurpleGiraffe</a></li>
        </ul>
      </section>
      
      <section id="settings" class="hidden">
        <p>Bearbeiten Sie Ihre Benutzereinstellungen:</p>
        

		<form action="ProfileUpdate" method="post">
			
			<p class="setting"><span>E-mail Address <img src="images/edit.png" alt="*Edit*"></span> <input type="text" name="email"></p>
        
			<p class="setting"><span>Vorname <img src="images/edit.png" alt="*Edit*"></span> <input type="text" name="first"></p>
			
			<p class="setting"><span>Nachname <img src="images/edit.png" alt="*Edit*"></span> <input type="text" name="last"></p>
			
			<p class="setting"><span>Interesse <img src="images/edit.png" alt="*Edit*"></span> <input type="text" name="interest"></p>
			
			<p class="setting"><span>Matrikelnummer<img src="images/edit.png" alt="*Edit*"></span> <input type="text" name="matrikNR"></p>
				
			<input type="submit" value="Submit" />
		</form>
      </section>
    </div><!-- @end #content -->
  </div><!-- @end #w -->
<script type="text/javascript">
$(function(){
  $('#profiletabs ul li a').on('click', function(e){
    e.preventDefault();
    var newcontent = $(this).attr('href');
    
    $('#profiletabs ul li a').removeClass('sel');
    $(this).addClass('sel');
    
    $('#content section').each(function(){
      if(!$(this).hasClass('hidden')) { $(this).addClass('hidden'); }
    });
    
    $(newcontent).removeClass('hidden');
  });
});
</script>
</body>
</html>