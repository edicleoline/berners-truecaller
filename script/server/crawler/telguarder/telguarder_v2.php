<?php

function request($offset, $count) {
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL, 'https://www.telguarder.com/br/countrysummary/comments');
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, "offset={$offset}&count={$count}");
    curl_setopt($ch, CURLOPT_ENCODING, 'gzip, deflate');
    // curl_setopt($ch, CURLOPT_HEADER, 1);
    
    $headers = array();
    $headers[] = 'Authority: www.telguarder.com';
    $headers[] = 'Sec-Ch-Ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"99\", \"Google Chrome\";v=\"99\"';
    $headers[] = 'Accept: */*';
    $headers[] = 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8';
    $headers[] = 'X-Requested-With: XMLHttpRequest';
    $headers[] = 'Sec-Ch-Ua-Mobile: ?0';
    $headers[] = 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36';
    $headers[] = 'Sec-Ch-Ua-Platform: \"Linux\"';
    $headers[] = 'Origin: https://www.telguarder.com';
    $headers[] = 'Sec-Fetch-Site: same-origin';
    $headers[] = 'Sec-Fetch-Mode: cors';
    $headers[] = 'Sec-Fetch-Dest: empty';
    $headers[] = 'Referer: https://www.telguarder.com/br';
    $headers[] = 'Accept-Language: en-US,en;q=0.9,pt;q=0.8';
    $headers[] = 'Cookie: deviceId=web2__e97b3d382121492893f032555e674a7b; _ga=GA1.2.676117731.1652304684; _pbjs_userid_consent_data=5108737104550201; panoramaId_expiry=1652909608778; _cc_id=5f5fd44a769ffc288dd1b4dc73f89b72; panoramaId=82cd5871d9bade3c1ec75d0ce9d94945a702b3f8447dbfbaefda95c3d08a1abe; _unifiedid=%7B%22TDID%22%3A%2290e064f2-7ca7-476e-b3f3-800a0823a6c1%22%2C%22TDID_LOOKUP%22%3A%22TRUE%22%2C%22TDID_CREATED_AT%22%3A%222022-04-11T21%3A33%3A28%22%7D; __gads=ID=10efddf6a2616ba8:T=1652304808:S=ALNI_MZ4dTXbsbDuYXf4aGSuyqLBSzRN2A; id5_storage=%7B%22created_at%22%3A%222022-05-11T21%3A33%3A29.351884Z%22%2C%22id5_consent%22%3Atrue%2C%22original_uid%22%3A%22ID5*pQ_V4El1oaHdzB-6oVgDMVbwKg8zeGGOozfCtRrIOEIRwe5_9Qmdcq3becij4kKsEcMoMx4gYsnnnXU6QsM2aRHECP8kW51tGReQgyjhFfkRxasGwOYMXv0LpslKXDiAEcYUh8OMOUvGZ9-xFkoWgBHIjNKBtapBTPRJ8ZKf3DkRydosEUN70ch-rKONoYEqEcofgqTj9AWzjBbC-5hxjRHL-_bDMMbQacom6xXwbrcRzNW_WcBtgxDw99UmZhkuEc12zar5xmXi3alenVYEvBHOhN1i5nOYmNEGNE1Jo6AR0PURntJceOYssRmO5IPrEdHJG9am858oOpb1gCiJRhHTtLLVkW9Jc282kVJ9n-AR1pGyqim7Ms7JwstlvqAyEdj9e2vEO_vUS5C-1vQvgBHZxJ2wHb4OFEoIloicGwgR2gh0RYorN2jhshicnTzIEdwL9bwpYmXOiz0VdB31_BHeFFM015TwBpH6Xal9LlAR31JqAQBB_9QZDVXB4GXx%22%2C%22universal_uid%22%3A%22ID5*16idn2m56tD1UlDk_Z2lBreEv8Z4dbrt4vXJmXJh_X0RwXaJ-7vU1uVb2Ah6qHLdEcN9oaGAXws11oZDDqyJ2hHEQZ8znQexjFwGaKtToG0RxYAmLVlT8g2h9yc9y6BMEcYL9g4XvfavS2SoIKlh-RHIwn0lJ7ugQBo8toNiRMgRyQjqs_5_bdh23BnS0qAyEcriPXeTYY7Xgkhpz9HR1BHLHi2RA0xBRbDb8GX-5m8RzJskbOR3o1eKlmMIYDWTEc3bfyrohqB4r8lBBIeBchHOEe-8D477N3fjvgwDhYAR0ITKM1oulZHKH2AtX29yEdGc7dBWvARpPSuxtKrXYhHTRnqhvOBN1Bi-WtWEu4IR1llN3za2YUetP4AcpuLgEdiE1zs2_k1n7TgOq3dXGxHZ2d1ih5baw1VC-GKW0kQR2rCAeSsY8ptvu56CxbMzEdxsKoIuAFpEA8vC-gHPjhHe04uHHp3dV6pZN4IGJG0R31LKFOzvAfALxfYPpCKP%22%2C%22signature%22%3A%22ID5_AYu9DhwmN-YPoD7E8x3v4gU2Nje8hdBahRPyIaYrcgQ1cAOkJThRh63YtV3Ff-SLKHDH6vdnaklVFe0gl-lk2xw%22%2C%22link_type%22%3A2%2C%22cascade_needed%22%3Afalse%2C%22privacy%22%3A%7B%22jurisdiction%22%3A%22gdpr%22%2C%22id5_consent%22%3Atrue%7D%7D; cto_bundle=rxQHZF9peGtHWjBzUjlyYmt5eElJaWhQb0pmNUZHTDNJcEFNdFRQc0FQOWRwdFVVdTF1JTJGdG1rcFBneGtKaXhDZFN1TlBxOHZ6emZCbzllb1hKdkJEdEpzdFhhS0tua2NTMCUyRndhdUo5R0xTMHlqdTI2eG9pOWtqV3ZwSzdzSnQwdDFRQmdrRjZhVkh1SHlzM3JKJTJCMkVTbVp4VHclM0QlM0Q; cto_bidid=aKXJQl9LRDNJa1UxakxhR0xrU293SW1iU2ZsSCUyRmVISlkxU3QxWThxbzBOY1M4eDhKVlRDMDNaT2wyM2JoeEd2WlolMkZvOENPVTZxM3UwTnZPSjR0NVBKYVFyV2J6Szl2R1pBd1cxVmdmV1duclVqUjdLM2F3NWRlNnpvdHVzQW5TJTJCaUglMkJu; _gid=GA1.2.1169113962.1652401211; cto_bundle=tOrbFl9peGtHWjBzUjlyYmt5eElJaWhQb0plOUlSc29tWVVmd1BaNFZSSiUyQllPekRLcHY3VGluRTNwNzRCUEVxcVBIcTR3MU10bFlycUMxbXVDcmQxN1M2VEJWSmNBUllUeUtTVG13R3RhOGN2cjZySWtheWN1b2xwZFZYc2xnWlBuQTJJZHVXSXlBS0FiY3ZIaTVpS2hnZWRXQSUzRCUzRA; cto_bundle=tOrbFl9peGtHWjBzUjlyYmt5eElJaWhQb0plOUlSc29tWVVmd1BaNFZSSiUyQllPekRLcHY3VGluRTNwNzRCUEVxcVBIcTR3MU10bFlycUMxbXVDcmQxN1M2VEJWSmNBUllUeUtTVG13R3RhOGN2cjZySWtheWN1b2xwZFZYc2xnWlBuQTJJZHVXSXlBS0FiY3ZIaTVpS2hnZWRXQSUzRCUzRA; didomi_token=eyJ1c2VyX2lkIjoiMTgwYjUwODktZTNmYy02ZjQ3LTkyOGEtNTM1MGNlYzkwYTlmIiwiY3JlYXRlZCI6IjIwMjItMDUtMTNUMDA6MjI6MzYuMTk3WiIsInVwZGF0ZWQiOiIyMDIyLTA1LTEzVDAwOjIyOjM2LjE5N1oiLCJ2ZW5kb3JzIjp7ImVuYWJsZWQiOlsiZ29vZ2xlIiwiYzpnb29nbGVhbmEtNFRYbkppZ1IiXX0sInB1cnBvc2VzIjp7ImRpc2FibGVkIjpbImRldmljZV9jaGFyYWN0ZXJpc3RpY3MiLCJnZW9sb2NhdGlvbl9kYXRhIl19LCJ2ZW5kb3JzX2xpIjp7ImVuYWJsZWQiOlsiZ29vZ2xlIl19LCJ2ZXJzaW9uIjoyLCJhYyI6IkRMd0FBQUFBQUJJQkJDSUFFRVFBQ0FRb0VZR1VBU0FRQUlDSUlCQWdBZ0ZBQkFBZ2dBSVFBQUVBTXdBZ0FBQUJFQUJFSkFFRkFJSUloSVFBQUFBaUV3UkFBREFBQ0FJQmdKS0FVQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFCRUFBQUFBQUFCQUFNQUJNQkFFQUJBQUFJQUFBRUlBQUlCQWdBQUFBQUJSQUFCQUFBSkZnZ2hRQUVBQUVDVkFRQUFFQkFRU0FJZ0FBS0lCTUVRQXlBQUFJQUFvSUNpQUVFQVFBQUFCQUNBd0JBQUFBRUJHQUFBQ2dRWUJBQUFBQkFBQ0lCQUFJQ0JJSUlCR0JBQkFBZ0FBQ0FCUUFVUVlnQUZFQWdHUUlBRUlBQkVBQ0lBQ0FvQUJRaHJRQUVDSUNnRUF3QUFRQVFBS0FBRG5BSUFBQ0VZQUFFQkVEQ0lDS29BQ2dBUlFRQ0NSSVVnZ0NBRkVnQUFRRW1rQWdBQVFBZ0FFZ0NBQkVpQ1NUd1FBbkFpREFFS0NWRXFCUUFJRUFGZ2lFQ294MGd3UURDd0tBZ0JuSlFZUVlET29FREdnM09Pd0dSQXN4SUJCZ0FFQVFBQUFCdUFDUmdrUU14Z01yaW5xTFZIdl8xMndNNzdsMERCWUlmcWNkY1hXMDZQREFKaHk5TVdyNkFHZFlyWV9Mb1pCSE1URU1DXzRvQUhOVGU3N01ORWdBLkRMd0FBQUFBQUJJQkJDSUFFQVFBQ0FRb0VZR1VBU0FRQUlDSUlCQWdBZ0ZBQkFBZ2dBSVFBQUVBTXdBZ0FBQUJFQUJFSkFFRkFJSUloSVFBQUFBaUV3UkFBREFBQ0FJQmdKS0FVQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFCRUFBQUFBQUFCQUFNQUJNQkFFQUJBQUFJQUFBRUlBQUlCQWdBQUFBQUJSQUFCQUFBSkZnZ2hRQUVBQUVDVkFRQUFFQkFRU0FJZ0FBS0lCTUVRQXlBQUFJQUFvSUNpQUVFQVFBQUFCQUNBd0JBQUFBRUJHQUFBQ2dRWUJBQUFBQkFBQ0lCQUFJQ0JJSUlCR0JBQkFBZ0FBQ0FCUUFVUVlnQUZFQWdHUUlBRUlBQkVBQ0lBQ0FvQUJRaHJRQUVDSUNnRUF3QUFRQVFBS0FBRG5BSUFBQ0VZQUFFQkVEQ0lDS29BQ2dBUlFRQ0NSSVVnZ0NBRkVnQUFRRW1rQWdBQVFBZ0FFZ0NBQkVpQ1NUd1FBbkFpREFFS0NWRXFCUUFJRUFGZ2lFQ294MGd3UURDd0tBZ0JuSlFZUVlET29FREdnM09Pd0dSQXN4SUJCZ0FFQVFBQUFCdUFDUmdrUU14Z01yaW5xTFZIdl8xMndNNzdsMERCWUlmcWNkY1hXMDZQREFKaHk5TVdyNkFHZFlyWV9Mb1pCSE1URU1DXzRvQUhOVGU3N01ORWdBIn0=; euconsent-v2=CPY6DsAPY6DsAAHABBENCOCgAAAAAAAAABpwIutf_X__b3_j-_5_f_t0eY1P9_7__-0zjhfdt-8N3f_X_L8X42M7vF36pq4KuR4Eu3LBIQdlHOHcTUmw6okVrzPsbk2cr7NKJ7PEmnMbO2dYGH9_n93TuZKY7_____7z_v-v_v____f_7-3f3__5_3---_e_V_99zbn9_____9nP___9v-_9________4IsgEmGpeQBdiWODJtGkUKIEYVhIdQKACigGFoisIHVwU7K4CfUELABAKgIwIgQYgowYBAAIBAEhEQEgB4IBEARAIAAQAKgEIACNgEFgBYGAQACgGhYgRQBCBIQZEBEcpgQESJRQT2ViCUHexphCHWWAFAo_oqEBEoAQLAyEhYOY4AkBLhZIFmKF8gBGCAAA.YAAAAAAAAAAA; __gpi=UID=0000056a5ebea613:T=1652304808:RT=1652462758:S=ALNI_MYK3SPkIy5DBl01-aYpBF6lOOyGBw; ARRAffinity=c7d9b2757694740fc4d56220fa1fa0eb189e003af7d6c3996f12b1068601831c; ARRAffinitySameSite=c7d9b2757694740fc4d56220fa1fa0eb189e003af7d6c3996f12b1068601831c; _gat_gtag_UA_1696383_25=1';
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    
    $result = curl_exec($ch);

    // $header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
    // $header = substr($result, 0, $header_size);
    // $body = substr($result, $header_size);

    if (curl_errno($ch)) {
        echo 'Error:' . curl_error($ch);
    }

    curl_close($ch);

    $httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    if($httpcode != 200) {
        echo "Error getting data: returned {$httpcode}" . PHP_EOL;
        renew_ip();
        return request($offset, $count);
        
        // $command = escapeshellcmd('python3 /home/berners/Documents/dev/web/truecaller/crawler/renew_ip_modem__mitra.py');
        // $output = shell_exec($command);
    }

    // if(!$result || strlen(trim($result)) == 0) {       
    //     renew_ip(); 
    //     return request($offset, $count);
    // }

    echo $result;
    die;

    return $result;
}

function renew_ip() {
    echo "Renewing IP..." . PHP_EOL;
    // exec('python3 /home/berners/Documents/dev/web/truecaller/crawler/renew_ip_modem__mitra.py 2>&1', $output, $return_var);

    $command = escapeshellcmd('python3 /home/berners/Documents/dev/web/truecaller/crawler/renew_ip_modem__mitra.py');
    $output = shell_exec($command);
    print($output . PHP_EOL);
}

function request_parse_store($filename, $offset, $count) {    
    $data = request($offset, $count);

    $dom = new DomDocument();
    $dom->loadHTML($data);
    $xpath = new DOMXpath($dom);

    $trs = $xpath->query('//tr');
    foreach ($trs as $tr)
    {
        $phone = $xpath->query("descendant::*[contains(@class, 'ai-phone')]", $tr)[0]->nodeValue;
        $spam_reason = $xpath->query("descendant::*[contains(@class, 'ai-spam-reason')]", $tr)[0]->nodeValue;
        $spam_reason = trim($spam_reason);
        
        $comment_mid = $xpath->query("descendant::*[contains(@class, 'ai-comment-mid-line')]", $tr)[0]->nodeValue;
        $comment = $xpath->query("descendant::td[contains(@class, 'ai-column-comment')]", $tr)[0]->nodeValue;
        $comment = trim(str_replace($comment_mid, '', $comment));        
        $comment = str_replace('"', '\\"', $comment);

        $timestamp = $xpath->query("descendant::*[contains(@class, 'ai-column-timestamp')]", $tr)[0]->nodeValue;

        $txt = '"' . $phone . '", "' . $spam_reason . '", "' . $comment . '", "' . $timestamp . '"';

        file_put_contents($filename, $txt.PHP_EOL , FILE_APPEND | LOCK_EX);
    }

    return count($trs);
}

function count_file_lines($filename) {
    $linecount = 0;

    $handle = fopen($filename, "r");
    while(!feof($handle)){
        $line = fgets($handle);
        $linecount++;
    }

    fclose($handle);

    return $linecount;
}

// $filename = date('Y-m-d_H-i-s') . '.csv';
// $filename = "all_v2_2.csv";
$filename = "all_v2.csv";

$offset = 0;
$offset = count_file_lines($filename) - 1;
$per_page = 100;
while(true) {
    echo "Getting [offset={$offset}], [per_page={$per_page}]" . PHP_EOL;
    $result_count = request_parse_store($filename, $offset, $per_page);
    $offset = $offset + $result_count;
    sleep(2);
}
