package com.example.mycollections.controllers;

import com.example.mycollections.models.MusicAlbum;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class MusicAlbumController {

    private final List<MusicAlbum> albums = new ArrayList<>() {{
        add(new MusicAlbum("The Tortured Poets Department: The Anthology", "Taylor Swift", 2024, 31));
        add(new MusicAlbum("Takin' It Back", "Meghan Trainor", 2023, 20));
        add(new MusicAlbum("The Weight of These Wings", "Miranda Lambert", 2016, 24));
    }};

    @GetMapping("/json")
    public List<MusicAlbum> getAlbumsJson() { return albums; }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (MusicAlbum album : albums) {
            albumList += "<li>" + album.getName() + ", " + album.getArtist() + ", " + album.getYear() + ", " + album.getTracks() + "</li>";
        }
        albumList += "<ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }
}
