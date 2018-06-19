       <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
        
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <span class="hidden-xs"><c:out value="${user.nom}"/> <c:out value="${user.prenom}"/></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->


              <!-- Menu Footer-->
              <li class="user-footer">
               
                  
                  <a href="admin?action=voirProfil" class="btn btn-default btn-flat">Voir Profil</a>
                 <br>
               


                <a href="admin?action=changerProfil" class="btn btn-default btn-flat">Changer Profil</a>
                                <br>
                  <a href="admin?action=changerMdp" class="btn btn-default btn-flat">Changer Mot de passe</a>
                
                <br>
                  <a href="admin?action=deconnecter" class="btn btn-default btn-flat">Déconnecter</a>
                
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->

        </ul>
      </div>