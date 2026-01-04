package domain;

/**
 * ImageConverter.java
 * <p>
 * Description: Facade pattern, simplify the system of multiple subsystems in 1
 *
 * @author aleja
 * @since 02/01/2026
 */

public class VideoGameFacade {
    private AudioEngine audioEngine;
    private GraphicEngine graphicEngine;
    private HUD hud;
    private Map map;
    private PhysicsSystem physicsSystem;
    Player player;

    public VideoGameFacade() {
        this.audioEngine = new AudioEngine();
        this.hud = new HUD();
        this.map = new Map();
        this.graphicEngine = new GraphicEngine();
        this.physicsSystem = new PhysicsSystem();
        this.player = new Player();
    }

    public void Play(String nameMap){
        System.out.println("Starting Game ...");
        this.graphicEngine.start();
        this.audioEngine.start();
        this.physicsSystem.start();
        this.player.create();
        this.map.charge(nameMap);
        this.player.enterMap(nameMap);
        this.hud.show();
    }
}
