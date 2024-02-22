﻿(function(n){"use strict";function i(n,t){if(this.createTextRange){var i=this.createTextRange();i.collapse(!0);i.moveStart("character",n);i.moveEnd("character",t-n);i.select()}else this.setSelectionRange&&(this.focus(),this.setSelectionRange(n,t))}function r(n){var u=this.value.length,t,i,r,f;return(n=n.toLowerCase()=="start"?"Start":"End",document.selection)?(t=document.selection.createRange(),i=t.duplicate(),i.expand("textedit"),i.setEndPoint("EndToEnd",t),r=i.text.length-t.text.length,f=r+t.text.length,n=="Start"?r:f):(typeof this["selection"+n]!="undefined"&&(u=this["selection"+n]),u)}var u={codes:{46:127,188:44,109:45,190:46,191:47,192:96,220:92,222:39,221:93,219:91,173:45,187:61,186:59,189:45,110:46},shifts:{96:"~",49:"!",50:"@",51:"#",52:"$",53:"%",54:"^",55:"&",56:"*",57:"(",48:")",45:"_",61:"+",91:"{",93:"}",92:"|",59:":",39:'"',44:"<",46:">",47:"?"}},f,t;n.fn.number=function(t,f,e,o){o=typeof o=="undefined"?",":o;e=typeof e=="undefined"?".":e;f=typeof f=="undefined"?0:f;var s="\\u"+("0000"+e.charCodeAt(0).toString(16)).slice(-4),h=new RegExp("[^"+s+"0-9]","g"),c=new RegExp(s,"g");return t===!0?this.is("input:text")?this.on({"keydown.format":function(t){var w=n(this),c=w.data("numFormat"),l=t.keyCode?t.keyCode:t.which,a="",s=r.apply(this,["start"]),y=r.apply(this,["end"]),p="",v=!1,h;if(u.codes.hasOwnProperty(l)&&(l=u.codes[l]),!t.shiftKey&&l>=65&&l<=90?l+=32:!t.shiftKey&&l>=69&&l<=105?l-=48:t.shiftKey&&u.shifts.hasOwnProperty(l)&&(a=u.shifts[l]),a==""&&(a=String.fromCharCode(l)),l!=8&&l!=45&&l!=127&&a!=e&&!a.match(/[0-9]/))return(h=t.keyCode?t.keyCode:t.which,h==46||h==8||h==127||h==9||h==27||h==13||(h==65||h==82||h==80||h==83||h==70||h==72||h==66||h==74||h==84||h==90||h==61||h==173||h==48)&&(t.ctrlKey||t.metaKey)===!0||(h==86||h==67||h==88)&&(t.ctrlKey||t.metaKey)===!0||h>=35&&h<=39||h>=112&&h<=123)?void 0:(t.preventDefault(),!1);if(s==0&&y==this.value.length||w.val()==0?l==8?(s=y=1,this.value="",c.init=f>0?-1:0,c.c=f>0?-(f+1):0,i.apply(this,[0,0])):a==e?(s=y=1,this.value="0"+e+new Array(f+1).join("0"),c.init=f>0?1:0,c.c=f>0?-(f+1):0):l==45?(s=y=2,this.value="-0"+e+new Array(f+1).join("0"),c.init=f>0?1:0,c.c=f>0?-(f+1):0,i.apply(this,[2,2])):(c.init=f>0?-1:0,c.c=f>0?-f:0):c.c=y-this.value.length,c.isPartialSelection=s==y?!1:!0,f>0&&a==e&&s==this.value.length-f-1)c.c++,c.init=Math.max(0,c.init),t.preventDefault(),v=this.value.length+c.c;else if(l==45&&(s!=0||this.value.indexOf("-")==0))t.preventDefault();else if(a==e)c.init=Math.max(0,c.init),t.preventDefault();else if(f>0&&l==127&&s==this.value.length-f-1)t.preventDefault();else if(f>0&&l==8&&s==this.value.length-f)t.preventDefault(),c.c--,v=this.value.length+c.c;else if(f>0&&l==127&&s>this.value.length-f-1){if(this.value==="")return;this.value.slice(s,s+1)!="0"&&(p=this.value.slice(0,s)+"0"+this.value.slice(s+1),w.val(p));t.preventDefault();v=this.value.length+c.c}else if(f>0&&l==8&&s>this.value.length-f){if(this.value==="")return;this.value.slice(s-1,s)!="0"&&(p=this.value.slice(0,s-1)+"0"+this.value.slice(s),w.val(p));t.preventDefault();c.c--;v=this.value.length+c.c}else l==127&&this.value.slice(s,s+1)==o?t.preventDefault():l==8&&this.value.slice(s-1,s)==o?(t.preventDefault(),c.c--,v=this.value.length+c.c):f>0&&s==y&&this.value.length>f+1&&s>this.value.length-f-1&&isFinite(+a)&&!t.metaKey&&!t.ctrlKey&&!t.altKey&&a.length===1&&(p=y===this.value.length?this.value.slice(0,s-1):this.value.slice(0,s)+this.value.slice(s+1),this.value=p,v=s);v!==!1&&i.apply(this,[v,v]);w.data("numFormat",c)},"keyup.format":function(t){var o=n(this),u=o.data("numFormat"),e=t.keyCode?t.keyCode:t.which,h=r.apply(this,["start"]),c=r.apply(this,["end"]),s;(h===0&&c===0&&(e===189||e===109)&&(o.val("-"+o.val()),h=1,u.c=1-this.value.length,u.init=1,o.data("numFormat",u),s=this.value.length+u.c,i.apply(this,[s,s])),this.value===""||(e<48||e>57)&&(e<96||e>105)&&e!==8&&e!==46&&e!==110)||(o.val(o.val()),f>0&&(u.init<1?(h=this.value.length-f-(u.init<0?1:0),u.c=h-this.value.length,u.init=1,o.data("numFormat",u)):h>this.value.length-f&&e!=8&&(u.c++,o.data("numFormat",u))),e!=46||u.isPartialSelection||(u.c++,o.data("numFormat",u)),s=this.value.length+u.c,i.apply(this,[s,s]))},"paste.format":function(t){var u=n(this),i=t.originalEvent,r=null;return window.clipboardData&&window.clipboardData.getData?r=window.clipboardData.getData("Text"):i.clipboardData&&i.clipboardData.getData&&(r=i.clipboardData.getData("text/plain")),u.val(r),t.preventDefault(),!1}}).each(function(){var t=n(this).data("numFormat",{c:-(f+1),decimals:f,thousands_sep:o,dec_point:e,regex_dec_num:h,regex_dec:c,init:this.value.indexOf(".")?!0:!1});this.value!==""&&t.val(t.val())}):this.each(function(){var t=n(this),i=+t.text().replace(h,"").replace(c,".");t.number(isFinite(i)?+i:0,f,e,o)}):this.text(n.number.apply(window,arguments))};f=null;t=null;n.isPlainObject(n.valHooks.text)?(n.isFunction(n.valHooks.text.get)&&(f=n.valHooks.text.get),n.isFunction(n.valHooks.text.set)&&(t=n.valHooks.text.set)):n.valHooks.text={};n.valHooks.text.get=function(t){var u=n(t),i,r=u.data("numFormat");return r?t.value===""?"":(i=+t.value.replace(r.regex_dec_num,"").replace(r.regex_dec,"."),(t.value.indexOf("-")===0?"-":"")+(isFinite(i)?i:0)):n.isFunction(f)?f(t):undefined};n.valHooks.text.set=function(i,r){var e=n(i),u=e.data("numFormat"),f;return u?(f=n.number(r,u.decimals,u.dec_point,u.thousands_sep),n.isFunction(t)?t(i,f):i.value=f):n.isFunction(t)?t(i,r):undefined};n.number=function(n,t,i,r){var f,e;r=typeof r=="undefined"?",":r;i=typeof i=="undefined"?".":i;t=isFinite(+t)?Math.abs(t):0;f="\\u"+("0000"+i.charCodeAt(0).toString(16)).slice(-4);e="\\u"+("0000"+r.charCodeAt(0).toString(16)).slice(-4);n=(n+"").replace(".",i).replace(new RegExp(e,"g"),"").replace(new RegExp(f,"g"),".").replace(new RegExp("[^0-9+-Ee.]","g"),"");var o=isFinite(+n)?+n:0,u="",s=function(n,t){return""+(+(Math.round((""+ n).indexOf("e")>0?n:n+"e+"+t)+"e-"+t))};return u=(t?s(o,t):""+Math.round(o)).split("."),u[0].length>3&&(u[0]=u[0].replace(/\B(?=(?:\d{3})+(?!\d))/g,r)),(u[1]||"").length<t&&(u[1]=u[1]||"",u[1]+=new Array(t-u[1].length+1).join("0")),u.join(i)}})(jQuery);