function VWZ_IsEmpty(a){a=sfm_str_trim(a);return a.length==0?true:false}function sfm_str_trim(a){return a.replace(/^\s\s*/,"").replace(/\s\s*$/,"")}function VWZ_IsChecked(a,b){if(a.length){for(var c=0;c<a.length;c++){if(a[c].checked=="1"&&a[c].value==b){return true}}}else{if(a.checked=="1"){return true}}return false}function VWZ_IsListItemSelected(a,b){for(var c=0;c<a.options.length;c++){if(a.options[c].selected==true&&a.options[c].value==b){return true}}return false}function validateInput(a,b,c){var d=true;var e=a.search("=");var f="";var g="";if(e>=0){f=a.substring(0,e);g=a.substr(e+1)}else{f=a}switch(f){case"req":case"required":{d=TestRequiredInput(b,c);break};case"maxlength":case"maxlen":{d=TestMaxLen(b,g,c);break};case"minlength":case"minlen":{d=TestMinLen(b,g,c);break};case"alnum":case"alphanumeric":{d=TestInputType(b,"[^A-Za-z0-9]",c,b.name+": Only alpha-numeric characters allowed ");break};case"alnum_s":case"alphanumeric_space":{d=TestInputType(b,"[^A-Za-z0-9\\s]",c,b.name+": Only alpha-numeric characters and space allowed ");break};case"num":case"numeric":case"dec":case"decimal":{if(b.value.length>0&&!b.value.match(/^[\-\+]?[\d\,]*\.?[\d]*$/)){sfm_show_error_msg(c,b);d=false}break};case"alphabetic":case"alpha":{d=TestInputType(b,"[^A-Za-z]",c,b.name+": Only alphabetic characters allowed ");break};case"alphabetic_space":case"alpha_s":{d=TestInputType(b,"[^A-Za-z\\s]",c,b.name+": Only alphabetic characters and space allowed ");break};case"email":{d=TestEmail(b,c);break};case"lt":case"lessthan":{d=TestLessThan(b,g,c);break};case"gt":case"greaterthan":{d=TestGreaterThan(b,g,c);break};case"regexp":{d=TestRegExp(b,g,c);break};case"dontselect":{d=TestDontSelect(b,g,c);break};case"dontselectchk":{d=TestDontSelectChk(b,g,c);break};case"shouldselchk":{d=TestShouldSelectChk(b,g,c);break};case"selmin":{d=TestSelMin(b,g,c);break};case"selmax":{d=TestSelMax(b,g,c);break};case"selone_radio":case"selone":{d=TestSelectOneRadio(b,c);break};case"dontselectradio":{d=TestSelectRadio(b,g,c,false);break};case"selectradio":{d=TestSelectRadio(b,g,c,true);break};case"eqelmnt":case"ltelmnt":case"leelmnt":case"gtelmnt":case"geelmnt":case"neelmnt":{return TestComparison(b,g,f,c);break};case"req_file":{d=TestRequiredInput(b,c);break};case"file_extn":{d=TestFileExtension(b,g,c);break}}return d}function TestSelectRadio(a,b,c,d){var e=a.form.elements[a.name];var f=false;for(var g=0;g<e.length;g++){if(e[g].value==b&&e[g].checked=="1"){f=true;break}}if(d==true&&false==f||d==false&&true==f){sfm_show_error_msg(c,a);return false}return true}function TestSelectOneRadio(a,b){var c=a.form.elements[a.name];var d=false;for(var e=0;e<c.length;e++){if(c[e].checked=="1"){d=true;break}}if(false==d){if(!b||b.length==0){b="Please select one option from "+a.name}sfm_show_error_msg(b,a)}return d}function TestDontSelect(a,b,c){var d=true;if(a.value==null){sfm_show_error_msg("Error: dontselect command for non-select Item",a);d=false}else if(a.value==b){if(!c||c.length==0){c=a.name+": Please Select one option "}sfm_show_error_msg(c,a);d=false}return d}function TestRegExp(a,b,c){var d=true;if(a.value.length>0&&!a.value.match(b)){if(!c||c.length==0){c=a.name+": Invalid characters found "}sfm_show_error_msg(c,a);d=false}return d}function TestGreaterThan(objValue,strGreaterThan,strError){var ret=true;var obj_value=objValue.value.replace(/\,/g,"");strGreaterThan=strGreaterThan.replace(/\,/g,"");if(isNaN(obj_value)){sfm_show_error_msg(objValue.name+": Should be a number ",objValue);ret=false}else if(eval(obj_value)<=eval(strGreaterThan)){if(!strError||strError.length==0){strError=objValue.name+" : value should be greater than "+strGreaterThan}sfm_show_error_msg(strError,objValue);ret=false}return ret}function TestLessThan(objValue,strLessThan,strError){var ret=true;var obj_value=objValue.value.replace(/\,/g,"");strLessThan=strLessThan.replace(/\,/g,"");if(isNaN(obj_value)){sfm_show_error_msg(objValue.name+": Should be a number ",objValue);ret=false}else if(eval(obj_value)>=eval(strLessThan)){if(!strError||strError.length==0){strError=objValue.name+" : value should be less than "+strLessThan}sfm_show_error_msg(strError,objValue);ret=false}return ret}function TestEmail(a,b){var c=true;if(a.value.length>0&&!validateEmail(a.value)){if(!b||b.length==0){b=a.name+": Enter a valid Email address "}sfm_show_error_msg(b,a);c=false}return c}function TestInputType(a,b,c,d){var e=true;var f=a.value.search(b);if(a.value.length>0&&f>=0){if(!c||c.length==0){c=d}sfm_show_error_msg(c,a);e=false}return e}function TestMinLen(objValue,strMinLen,strError){var ret=true;if(eval(objValue.value.length)<eval(strMinLen)){if(!strError||strError.length==0){strError=objValue.name+" : "+strMinLen+" characters minimum  "}sfm_show_error_msg(strError,objValue);ret=false}return ret}function TestMaxLen(objValue,strMaxLen,strError){var ret=true;if(eval(objValue.value.length)>eval(strMaxLen)){if(!strError||strError.length==0){strError=objValue.name+" : "+strMaxLen+" characters maximum "}sfm_show_error_msg(strError,objValue);ret=false}return ret}function TestFileExtension(a,b,c){var d=false;var e=false;if(a.value.length<=0){return true}var f=b.split(";");for(var g=0;g<f.length;g++){ext=a.value.substr(a.value.length-f[g].length,f[g].length);ext=ext.toLowerCase();if(ext==f[g]){e=true;break}}if(!e){if(!c||c.length==0){c=a.name+" allowed file extensions are: "+b}sfm_show_error_msg(c,a);d=false}else{d=true}return d}function TestRequiredInput(a,b){var c=true;if(VWZ_IsEmpty(a.value)){c=false}else if(a.getcal&&!a.getcal()){c=false}if(!c){if(!b||b.length==0){b=a.name+" : Required Field"}sfm_show_error_msg(b,a)}return c}function TestShouldSelectChk(a,b,c){var d=true;d=IsCheckSelected(a,b)?true:false;if(d==false){if(!c||c.length==0){c="You should select"+a.name}sfm_show_error_msg(c,a)}return d}function TestDontSelectChk(a,b,c){var d=true;d=IsCheckSelected(a,b)?false:true;if(d==false){if(!c||c.length==0){c="Can't Proceed as you selected "+a.name}sfm_show_error_msg(c,a)}return d}function IsCheckSelected(a,b){var c=false;var d=a.form.elements[a.name];if(d.length){var e=-1;for(var f=0;f<d.length;f++){if(d[f].value==b){e=f;break}}if(e>=0){if(d[e].checked=="1"){c=true}}}else{if(a.checked=="1"){c=true}}return c}function TestSelMax(objValue,strMaxSel,strError){var bret=true;var objcheck=objValue.form.elements[objValue.name];var chkcount=0;if(objcheck.length){for(var c=0;c<objcheck.length;c++){if(objcheck[c].checked=="1"){chkcount++}}}else{chkcount=objcheck.checked=="1"?1:0}var maxsel=eval(strMaxSel);if(chkcount>maxsel){if(!strError||strError.length==0){strError="Please Select atmost "+maxsel+" check boxes for"+objValue.name}sfm_show_error_msg(strError,objValue);bret=false}return bret}function TestSelMin(objValue,strMinSel,strError){var bret=true;var objcheck=objValue.form.elements[objValue.name];var chkcount=0;if(objcheck.length){for(var c=0;c<objcheck.length;c++){if(objcheck[c].checked=="1"){chkcount++}}}else{chkcount=objcheck.checked=="1"?1:0}var minsel=eval(strMinSel);if(chkcount<minsel){if(!strError||strError.length==0){strError="Please Select atleast"+minsel+" check boxes for"+objValue.name}sfm_show_error_msg(strError,objValue);bret=false}return bret}function TestComparison(objValue,strCompareElement,strvalidator,strError){var bRet=true;var objCompare=null;if(!objValue.form){sfm_show_error_msg("Error: No Form object!",objValue);return false}objCompare=objValue.form.elements[strCompareElement];if(!objCompare){sfm_show_error_msg("Error: Element with name"+strCompareElement+" not found !",objValue);return false}var objval_value=objValue.value;var objcomp_value=objCompare.value;if(strvalidator!="eqelmnt"&&strvalidator!="neelmnt"){objval_value=objval_value.replace(/\,/g,"");objcomp_value=objcomp_value.replace(/\,/g,"");if(isNaN(objval_value)){sfm_show_error_msg(objValue.name+": Should be a number ",objValue);return false}if(isNaN(objcomp_value)){sfm_show_error_msg(objCompare.name+": Should be a number ",objCompare);return false}}var cmpstr="";switch(strvalidator){case"eqelmnt":{if(objval_value!=objcomp_value){cmpstr=" should be equal to ";bRet=false}break};case"ltelmnt":{if(eval(objval_value)>=eval(objcomp_value)){cmpstr=" should be less than ";bRet=false}break};case"leelmnt":{if(eval(objval_value)>eval(objcomp_value)){cmpstr=" should be less than or equal to";bRet=false}break};case"gtelmnt":{if(eval(objval_value)<=eval(objcomp_value)){cmpstr=" should be greater than";bRet=false}break};case"geelmnt":{if(eval(objval_value)<eval(objcomp_value)){cmpstr=" should be greater than or equal to";bRet=false}break};case"neelmnt":{if(objval_value.length>0&&objcomp_value.length>0&&objval_value==objcomp_value){cmpstr=" should be different from ";bRet=false}break}}if(bRet==false){if(!strError||strError.length==0){strError=objValue.name+cmpstr+objCompare.name}sfm_show_error_msg(strError,objValue)}return bRet}function validateEmail(a){var b=a.match("^(.+)@(.+)$");if(b==null)return false;if(b[1]!=null){var c=/^\"?[\w-_\.]*\"?$/;if(b[1].match(c)==null)return false}if(b[2]!=null){var d=/^[\w-\.]*\.[A-Za-z]{2,4}$/;if(b[2].match(d)==null){var e=/^\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\]$/;if(b[2].match(e)==null)return false}return true}return false}function vset_validate(){var a=true;for(var b=0;b<this.vSet.length;b++){a=a&&this.vSet[b].validate();if(!a&&!this.msgs_together){break}}return a}function add_validationdesc(a,b,c){this.vSet[this.vSet.length]=new ValidationDesc(this.itemobj,a,b,c)}function ValidationSet(a,b){this.vSet=new Array;this.add=add_validationdesc;this.validate=vset_validate;this.itemobj=a;this.msgs_together=b}function vdesc_validate(){if(this.condition!=null){if(!eval(this.condition)){return true}}if(!validateInput(this.desc,this.itemobj,this.error)){this.itemobj.validatorobj.focus_disable_validations=true;sfm_set_focus(this.itemobj);return false}return true}function ValidationDesc(a,b,c,d){this.desc=b;this.error=c;this.itemobj=a;this.condition=d;this.validate=vdesc_validate}function show_div_msg(a,b){if(a.length<=0)return false;if(document.layers){divlayer=document.layers[a];if(!divlayer){return}divlayer.document.open();divlayer.document.write(b);divlayer.document.close()}else if(document.all){divlayer=document.all[a];if(!divlayer){return}divlayer.innerHTML=b}else if(document.getElementById){divlayer=document.getElementById(a);if(!divlayer){return}divlayer.innerHTML=b}divlayer.style.visibility="visible"}function div_showmsg(a){var b;var c=null;for(var d in a){if(null==c){c=a[d]["input_element"]}var e=element_div_name(a[d]["input_element"]);show_div_msg(e,a[d]["msg"])}if(null!=c){sfm_set_focus(c)}}function element_div_name(a){var b=a.form._sfm_form_name+"_"+a.name+"_errorloc";b=b.replace(/[\[\]]/gi,"");return b}function div_clearmsg(a){for(var b in a){var c=element_div_name(a[b]["input_element"]);show_div_msg(c,"")}}function DivMsgDisplayer(){this.showmsg=div_showmsg;this.clearmsg=div_clearmsg}function sfm_show_div_msg(a,b){if(a.length<=0)return false;if(document.layers){divlayer=document.layers[a];if(!divlayer){return}divlayer.document.open();divlayer.document.write(b);divlayer.document.close()}else if(document.all){divlayer=document.all[a];if(!divlayer){return}divlayer.innerHTML=b}else if(document.getElementById){divlayer=document.getElementById(a);if(!divlayer){return}divlayer.innerHTML=b}divlayer.style.visibility="visible";return false}function form_error_div_name(a){var b=null;for(var c in a){b=a[c]["input_element"];if(b){break}}var d="";if(b){d=b.form._sfm_form_name+"_errorloc"}return d}function sb_div_showmsg(a){var b="<ul>\n";for(var c=0;c<a.length;c++){b+="<li>"+a[c]["msg"]+"</li>\n"}b+="</ul>";var d=form_error_div_name(a);var e=d+"_loc";b="<a name='"+e+"' >"+b;sfm_show_div_msg(d,b);window.location.hash=e}function sb_div_clearmsg(a){var b=form_error_div_name(a);sfm_show_div_msg(b,"")}function SingleBoxErrorDisplay(){this.showmsg=sb_div_showmsg;this.clearmsg=sb_div_clearmsg}function sfm_show_error_msg(a,b){document.error_disp_handler.ShowMsg(a,b)}function alert_showmsg(a){var b="";var c=null;for(var d=0;d<a.length;d++){if(null==c){c=a[d]["input_element"]}b+=a[d]["msg"]+"\n"}alert(b);if(null!=c){sfm_set_focus(c)}}function alert_clearmsg(a){}function AlertMsgDisplayer(){this.showmsg=alert_showmsg;this.clearmsg=alert_clearmsg}function edh_ShowMsg(a,b){var c=new Array;c["input_element"]=b;c["msg"]=a;this.all_msgs.push(c)}function edh_EnableOnPageDisplay(a){if(true==a){this.msgdisplay=new SingleBoxErrorDisplay}else{this.msgdisplay=new DivMsgDisplayer}}function edh_FinalShowMsg(){if(this.all_msgs.length==0){return}this.msgdisplay.showmsg(this.all_msgs)}function edh_clear_msgs(){this.msgdisplay.clearmsg(this.all_msgs);this.all_msgs=new Array}function sfm_ErrorDisplayHandler(){this.msgdisplay=new AlertMsgDisplayer;this.EnableOnPageDisplay=edh_EnableOnPageDisplay;this.ShowMsg=edh_ShowMsg;this.FinalShowMsg=edh_FinalShowMsg;this.all_msgs=new Array;this.clear_msgs=edh_clear_msgs}function validator_enable_OPED_SB(){document.error_disp_handler.EnableOnPageDisplay(true)}function validator_enable_OPED(){document.error_disp_handler.EnableOnPageDisplay(false)}function handle_item_on_killfocus(){if(this.validatorobj.focus_disable_validations==true){this.validatorobj.focus_disable_validations=false;return false}if(null!=this.validationset){document.error_disp_handler.clear_msgs();if(false==this.validationset.validate()){document.error_disp_handler.FinalShowMsg();return false}}}function add_validation(a,b,c){var d=null;if(arguments.length>3){d=arguments[3]}if(!this.formobj){alert("Error: The form object is not set properly");return}var e=this.formobj[a];if(e.length&&isNaN(e.selectedIndex)){e=e[0]}if(!e){alert("Error: Couldnot get the input object named: "+a);return}if(true==this.validate_on_killfocus){e.onblur=handle_item_on_killfocus}if(!e.validationset){e.validationset=new ValidationSet(e,this.show_errors_together)}e.validationset.add(b,c,d);e.validatorobj=this}function form_submit_handler(){var a=true;document.error_disp_handler.clear_msgs();for(var b=0;b<this.elements.length;b++){if(this.elements[b].validationset&&!this.elements[b].validationset.validate()){a=false}if(!a&&!this.show_errors_together){break}}if(this.show_errors_together||a&&!this.show_errors_together){if(!this.runAddnlValidations()){a=false}}if(!a){document.error_disp_handler.FinalShowMsg();return false}return true}function clear_all_validations(){for(var a=0;a<this.formobj.elements.length;a++){this.formobj.elements[a].validationset=null}}function sfm_validator_message_disp_pos(a){this.formobj.error_display_loc=a}function sfm_enable_show_msgs_together(){this.show_errors_together=true;this.formobj.show_errors_together=true}function sfm_disable_validations(){if(this.old_onsubmit){this.onsubmit=this.old_onsubmit}else{this.onsubmit=null}}function sfm_set_focus(a){if(document.set_focus_onerror){if(!a.disabled&&a.type!="hidden"){a.focus()}}}function run_addnl_validations(){var a=true;for(var b=0;b<this.addnlvalidations.length;b++){var c=this.addnlvalidations[b];var d=c.arguments||[];if(!c.func.apply(null,d)){a=false}}return a}function set_addnl_vfunction(a){if(a.constructor==String){alert("Pass the function name like this: validator.setAddnlValidationFunction(DoCustomValidation)\n "+"rather than passing the function name as string");return}this.addAddnlValidationFunction(a)}function add_addnl_vfunction(){var a={};a.func=arguments[0];a.arguments=[];for(var b=1;b<arguments.length;b++){a.arguments.push(arguments[b])}this.formobj.addnlvalidations.push(a)}function sfm_validator_enable_focus(a){document.set_focus_onerror=a}function Validator(a){this.validate_on_killfocus=false;this.formobj=document.forms[a];if(!this.formobj){alert("Error: couldnot get Form object "+a);return}if(this.formobj.onsubmit){this.formobj.old_onsubmit=this.formobj.onsubmit;this.formobj.onsubmit=null}else{this.formobj.old_onsubmit=null}this.formobj._sfm_form_name=a;this.formobj.onsubmit=form_submit_handler;this.addValidation=add_validation;this.formobj.addnlvalidations=new Array;this.addAddnlValidationFunction=add_addnl_vfunction;this.formobj.runAddnlValidations=run_addnl_validations;this.setAddnlValidationFunction=set_addnl_vfunction;this.clearAllValidations=clear_all_validations;this.focus_disable_validations=false;document.error_disp_handler=new sfm_ErrorDisplayHandler;this.EnableOnPageErrorDisplay=validator_enable_OPED;this.EnableOnPageErrorDisplaySingleBox=validator_enable_OPED_SB;this.show_errors_together=false;this.EnableMsgsTogether=sfm_enable_show_msgs_together;document.set_focus_onerror=true;this.EnableFocusOnError=sfm_validator_enable_focus;this.formobj.error_display_loc="right";this.SetMessageDisplayPos=sfm_validator_message_disp_pos;this.formobj.DisableValidations=sfm_disable_validations;this.formobj.validatorobj=this}