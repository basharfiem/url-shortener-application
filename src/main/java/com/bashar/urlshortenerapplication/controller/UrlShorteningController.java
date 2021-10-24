package com.bashar.urlshortenerapplication.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bashar.urlshortenerapplication.model.Url;
import com.bashar.urlshortenerapplication.model.UrlDto;
import com.bashar.urlshortenerapplication.model.UrlErrorResponseDto;
import com.bashar.urlshortenerapplication.model.UrlResponseDto;
import com.bashar.urlshortenerapplication.service.UrlService;


@RestController
public class UrlShorteningController {

	@Autowired
	UrlService urlService;
	

	@RequestMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }
	
	
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto)
	{
		Url urlToRet = urlService.generateShorLink(urlDto);
		
		if(urlToRet != null)
		{
			UrlResponseDto urlResponseDto = new UrlResponseDto();
			urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
			urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
			urlResponseDto.setShortUrl(urlToRet.getShortLink());
			
			return new ResponseEntity<UrlResponseDto>(urlResponseDto,HttpStatus.OK);
		}
		
		UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
		urlErrorResponseDto.setStatus("404");
		urlErrorResponseDto.setError("There was an error while processing your request. Please try Again!");
		
		return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
	}
	

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {

        if(StringUtils.isEmpty(shortLink))
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("Invalid Url");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }
        Url urlToRet = urlService.getEncodedLink(shortLink);

        if(urlToRet == null)
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("Url does not exist!");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }

        if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now()))
        {
           // urlService.deleteShortLink(urlToRet);
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("Url Expired. Please try generating a fresh one.");
            urlErrorResponseDto.setStatus("200");
            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }

        response.sendRedirect(urlToRet.getOriginalUrl());
        return null;
    }
    
    @GetMapping("getAll")
    public ResponseEntity<?> getAllExistingUrl(HttpServletResponse response)
    {
    	 List<Url> urlListToRet = urlService.getAllExistingUrl();
    	
    	 List<UrlResponseDto> urlList = new ArrayList<>();
    	 
    	 for (Url url : urlListToRet) {
    		 UrlResponseDto urlResponseDto = new UrlResponseDto();
    		 urlResponseDto.setOriginalUrl(url.getOriginalUrl());
    		 urlResponseDto.setShortUrl(url.getShortLink());
    		 urlList.add(urlResponseDto);
		}
    	return new ResponseEntity<List<UrlResponseDto>>(urlList,HttpStatus.OK);    	
    }
	
	
}
