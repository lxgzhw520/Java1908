# Navbar
$ ->
  $(".navbar-expand-toggle").click ->
    $(".app-container").toggleClass "expanded"
    $(".navbar-expand-toggle").toggleClass "fa-rotate-90"

  $(".navbar-right-expand-toggle").click ->
    $(".navbar-right").toggleClass "expanded"
    $(".navbar-right-expand-toggle").toggleClass "fa-rotate-90"

$ ->
  $('select').select2();

# Bootstrap Toggle
$ ->
  $('.toggle-checkbox').bootstrapSwitch({
    size: "small"
    });


# Match Height
$ ->
  $('.match-height').matchHeight();

# DataTable
$ ->
  $('.datatable').DataTable({
    "dom": '<"top"fl<"clear">>rt<"bottom"ip<"clear">>'
    });

$ ->
  $(".side-menu .nav .dropdown").on 'show.bs.collapse', ->
    $(".side-menu .nav .dropdown .collapse").collapse('hide')