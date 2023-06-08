
        	// 중복 submit 방지
        	var formSubmited = false;

        	$j('#QuickSearch').submit(QuickSearch_Submit);

        	function QuickSearch_Submit(e) {
        		if (formSubmited == true) {   // 중복 submit 체크
        			e.preventDefault();
        			e.stopPropagation();
        			return;
        		}

        		var f = $j('#QuickSearch');
        		if (f.attr("isusedstore") == 1) {
        			if (f.find("#KeyTag").length > 0) {
        				f.attr("action", "/search/wsearchresult.aspx");
        				f.find("#SearchTarget").val("UsedStore");
        			} else {
        				f.attr("action", "/usedstore/wsearchresult.aspx");
        				f.find("#SearchTarget").val("Used");
        			}
        		}

        		formSubmited = true;
        	}
        