package com.example.restaurant.fake;

import org.springframework.web.bind.annotation.*;

@RestController
public class FakeController {
    @GetMapping("/fake")
    public String fake(){
        return "Fake";
    }

    @GetMapping("/fake/params")
    public String fakeParams(@RequestParam String name){
        return "No name";
    }

    @GetMapping("fake/{condition}")
    public String fakeCondition(@PathVariable boolean condition){
        return condition ? "YES" : "NO";
    }

    @PostMapping("/fake")
    public String fakePost(@RequestBody FakeObject fakeObject){
        return fakeObject.getName();
    }
}
