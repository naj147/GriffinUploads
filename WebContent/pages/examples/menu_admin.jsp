

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
            <span class="fa fa-user"></span>
        </div>
        <div class="info">
          <p> <c:out value="${user.nom}"/> <c:out value="${user.prenom}"/> </p>
        </div>
      </div>
      <!-- search form -->

      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        
        <li><a href="admin"><i class="fa fa-group"></i> <span>
        Gestion des utilisateurs</span></a></li>


        <li><a href="admin?action=addAdmin"><i class="fa fa-user-plus"></i> <span>
        Ajouter un admin</span></a></li>

        <li><a href="admin?action=voirProfil"><i class="fa fa-user"></i> <span>Voir Profil</span></a></li>
        <li><a href="admin?action=changerProfil"><i class="fa fa-cogs"></i> <span>Changer Profil</span></a></li>

      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>