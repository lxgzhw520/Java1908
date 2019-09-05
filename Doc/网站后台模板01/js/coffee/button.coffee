# Code Preview 
$ ->
  HtmlMode = ace.require("ace/mode/html").Mode;
  editor = ace.edit("code-preview-button");
  editor.getSession().setMode(new HtmlMode());
  editor.setTheme("ace/theme/github");

  editor = ace.edit("code-preview-button-group");
  editor.getSession().setMode(new HtmlMode());
  editor.setTheme("ace/theme/github");

  editor = ace.edit("code-preview-button-dropdown");
  editor.getSession().setMode(new HtmlMode());
  editor.setTheme("ace/theme/github");

