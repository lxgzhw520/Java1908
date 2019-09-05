# Code Preview 
$ ->
  HtmlMode = ace.require("ace/mode/html").Mode;
  editor = ace.edit("code-preview-alert");
  editor.getSession().setMode(new HtmlMode());
  editor.setTheme("ace/theme/github");