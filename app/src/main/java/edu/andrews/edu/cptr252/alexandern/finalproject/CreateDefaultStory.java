package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.media.metrics.Event;

public class CreateDefaultStory {

    private DAOEvents helper;
    private String MENU = "mainMenu";
    private String NO = "noEvent";
    private Context context;

    public CreateDefaultStory(Context context) {
        this.context=context;
    }

    private EventData createEvent(String title, String Id, String text,
                                  String choice1Text, String choice1ID,
                                  String choice2Text, String choice2ID) {
        EventData tempEvent = new EventData();
        EventData newEvent = new EventData();
        if (choice1ID.equals(MENU)) {
            newEvent.setChoice1id(-2L);
        } else if (choice1ID.equals(NO)) {
            newEvent.setChoice1id(-5L);
        } else {
            tempEvent.setId(choice1ID);
            EventData choice1Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice1id(choice1Event.getIdDB());
        }

        if (choice2ID.equals(MENU)) {
            newEvent.setChoice2id(-2L);
        } else if (choice2ID.equals(NO)) {
            newEvent.setChoice2id(-5L);
        } else {
            tempEvent.setId(choice2ID);
            EventData choice2Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice2id(choice2Event.getIdDB());
        }

        newEvent.setName(title);
        newEvent.setId(Id);
        newEvent.setText(text);
        newEvent.setChoice1txt(choice1Text);
        newEvent.setChoice2txt(choice2Text);

        return newEvent;
    }

    private EventData createEvent(String title, String Id, String text,
                                  String choice1Text, String choice1ID,
                                  String choice2Text, String choice2ID, Boolean isInitial) {
        EventData tempEvent = new EventData();
        EventData newEvent = new EventData();
        if (choice1ID.equals(MENU)) {
            newEvent.setChoice1id(-2L);
        } else if (choice1ID.equals(NO)) {
            newEvent.setChoice1id(-5L);
        } else {
            tempEvent.setId(choice1ID);
            EventData choice1Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice1id(choice1Event.getIdDB());
        }

        if (choice2ID.equals(MENU)) {
            newEvent.setChoice2id(-2L);
        } else if (choice2ID.equals(NO)) {
            newEvent.setChoice2id(-5L);
        } else {
            tempEvent.setId(choice2ID);
            EventData choice2Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice2id(choice2Event.getIdDB());
        }

        newEvent.setName(title);
        newEvent.setId(Id);
        newEvent.setText(text);
        newEvent.setChoice1txt(choice1Text);
        newEvent.setChoice2txt(choice2Text);
        newEvent.setIsInitial("1");

        return newEvent;
    }

    public void createStory() {
        helper = new DAOEvents(this.context);
        helper.insertEvent(createEvent(
                "36","36",//Title, Id
                "“Alright then,” she says, smiling. “Get on my back, if you will.”\n" +
                        "\n" +
                        "You do so. Woebegone slowly rises up with a sound like gunfire—it’s a little dizzying, being this high up with only her spine (well, her spine spine, but you know) holding you up—and turns toward the windows. Something that is DEFINITELY the Sun DOES NOT look back at you steadily. Possibly many things.\n" +
                        "\n" +
                        "The Head Counselor dashes headfirst through the glass, revealing a landscape at once both familiar and bizarre—trees with veins, a parking lot crumpled up like tissue paper, a playground that looks like it was designed for children with a rather different arrangement of limbs—and you ride off into what will, if everything goes according to plan, not too long from now be the sunrise.\n",//Text
                "The end",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)
        ));
        helper.insertEvent(createEvent(
                "35","35",//Title, Id
                "And then you’re gone.",//Text
                "The end?",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "33","33",//Title, Id
                "“...What?” Her neck rears back, and she tilts her head quizzically, making a sound like evil bubble wrap all the while. “(heroName), you’ve never really been one for sarcasm. What gives?”\n" +
                        "\n" +
                        "“Sorry, but all this stuff’s a human problem, and with the way stuff like this works I’m probably going to have to sacrifice my life or something at the end, except there’ll, like, maybe be a chance that I survive by some contrived twist? Either way, that’s not what I signed up for!”\n" +
                        "\n" +
                        "“Oh my MOON you’re actually serious aren’t you.”\n" +
                        "\n" +
                        "“I’ll take that as a ‘yes’ regarding the whole ‘person sacrifice’ part.”\n" +
                        "\n" +
                        "She nods, reluctantly.\n" +
                        "\n" +
                        "“So yeah, I think I’ll be skedaddling back home to the elf dimension. Hope you find someone else.” You pause. “…I really do hope that, you know. Try being more upfront about the costs with them, though—honestly, I might have agreed if you had.”\n" +
                        "\n" +
                        "“I… don’t like it, but I understand,” she says. “If things get better, I’ll contact you.” \n",//Text
                "Thanks","35",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "32","32",//Title, Id
                "“You hope you’re the only one with the nices? What a terrible thing to say!”\n" +
                        "\n" +
                        "“No, no, I meant—”\n" +
                        "\n" +
                        "“I know what you meant, (heroName),” she says, smiling. “Your jokes might be a little rusty—or unthawed, rather—at the moment, but I’m sure you’ll be back to your usual self in no time. We’re going to need that. Everyone’s going to need that. So… will you come with me to Camp Bonegame, where it all began, and help save the world?”\n",//Text
                "No","33",//Choice1Text, Choice1ID
                "Heck yeah!","36"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "31","31",//Title, Id
                "“(heroName)… I’ve studied the matter inside and out, and while the Soda Supernova may have been immeasurably greater than anything the world has seen before, and even managed to rope entities or forces hitherto unknown to humanity into its melting pot of horrors, it still fundamentally operates on the same principles that summer camp occultism always has. And that means…”\n" +
                        "\n" +
                        "“It can be reversed!” you say, your eyes widening.\n" +
                        "\n" +
                        "“Only partially, but yes. The thing is… something of this scale can’t be reversed ‘from the inside’. In this case, the counter-ritual requires someone entirely untouched by the first ritual within the bounds of its originally intended domain. Which is to say, someone who never once so much as glanced out of a window for the first four months after the Last Day—and while there aren’t exactly ‘days’ anymore, we’re definitely long past that point. Only such a person will be capable of rectifying the spirit of Summer.”\n" +
                        "\n" +
                        "“So I… I qualify. Aside from my hat disappearing, but I guess that doesn’t really count?”\n" +
                        "\n" +
                        "“Yes. And most likely, you’re the only one with both the knowledge and the means to do so.”\n",//Text
                "And the nices, I hope!","32",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "30","30",//Title, Id
                "“There are… a lot of parts that are difficult if not literally impossible to talk about. But I think that you can probably guess at some of the broad strokes. Remember 2011, when James Cooper used bubblegum that he’d already chewed up for the—”\n" +
                        "\n" +
                        "“Oh, gosh! Don’t remind me!”\n" +
                        "\n" +
                        "“As far as the ‘deets’ are concerned… I can try filling you in as we go. This section’s exposition-dumpy enough as it is.”\n" +
                        "\n" +
                        "“…As we go?”\n" +
                        "\n" +
                        "“Yes, (heroName). You’ve got a long road ahead of you.”\n",//Text
                "What do I have to do with this?","31",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "28","28",//Title, Id
                "“Yes. Civilization fell, billions died, the works. And if they came back they’d die all over again, probably in even more creative ways. Next question.”\n" +
                        "\n" +
                        "“Dang. Now I’m sad.”\n" +
                        "\n" +
                        "“All of the hats got raptured, too, pretty early on,” she says with a twisted, ironic grin. “Not a single one left on planet Earth,”\n" +
                        "\n" +
                        "“Well now I’m really sad! Even if… they’re in a better place now.”\n" +
                        "\n" +
                        "“Yes, a real tragedy.” she says, a surprisingly genuine moroseness in her voice. You never knew her to be a big Hat Fan. “Next question.”\n",//Text
                "What is it like out there?","30",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "29","29",//Title, Id
                "“As long as I stay here, I’m still ‘doing my job’, which affords me a least some level of protection. Early on this place still had it pretty bad due to, like I mentioned, its proximity to ‘ground zero’, but from my limited knowledge of the global situation it seems like over time the… badness-levels have gradually evened out, at least within the Day Side. Come to a sort of equilibrium.” (I took Thermodynamics last semester.)\n" +
                        "\n" +
                        "“Besides… I’ve kind of been waiting for you.”\n",//Text
                "Is it that bad outside?","28",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "25","25",//Title, Id
                "“Just my little nickname for the apocalypse.” she says. “The Aurora Terminal, the Focal Antitheosis… I think it’s fond of stuff like that, you know—fancy words, poetic epithets. It’s silly… but only in a distant, ironic way. I’ve come to suspect that that’s part of its nature: absurdity, everything done in an over-the-top manner—and yet bitter, horrific, twisted, devoid of any genuine mirth. Its drama is self-serious, its absurdity as much to confuse and dissatisfy as to amuse. I think… I think that’s part of why you come in. But I’m getting ahead of myself.\n" +
                        "\n" +
                        "“The actual event is… let’s just say it’s ‘HARD to TALK ABOUT’.” She grimaces slightly as she seems to mockingly imitate a voice that you’re unfamili… actually, you somehow feel like you actually have heard it before. In a dream? No, that’s not quite right… Woebegone continues:\n" +
                        "\n" +
                        "“The cause took a while to figure out, but let’s just say that an old friend of mine, who was working as a store clerk at another summer camp not too far from here at the time, let the rather demanding camp store initiation ritual… get to him over the years, and he began to lose touch with his common sense in… certain ways. One summer solstice—camp hadn’t quite started here yet—he substituted a novelty lamp and a Diet Coke™-Mentos™ combo for the usual sacrifices and, well, nobody would have ever suspected the true extent of the consequences.”\n",//Text
                "Is it that bad outside?","28",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "27","27",//Title, Id
                "“…Let’s just say I forgot my ‘sunscreen’. I’d rather not talk about the details. I still hate this with, very literally, every bone in my body, but I’ve gotten as used to it as one can over the years. Sorry I couldn’t get you out of the freezer myself—I’ve tried loads of times, but I have a hard time even getting into the kitchen, my dexterity’s crap, and I’ve had… issues getting assistance.”\n" +
                        "\n" +
                        "She sighs.\n" +
                        "\n" +
                        "“I wish I could at least breathe fire or fly or something. That filthy cheapskate… But all that’s in the past. I got off lucky, especially considering our relative proximity to ground zero. Besides… a lot more can burn than your physical body. Especially when all you’ve got between you and the sky is less than a centimeter of broken bone.”\n",//Text
                "Why are you still here?","29",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "24","24",//Title, Id
                "\"Sure thing, buddy.\" she says, smiling wryly. \"Ask away.\"",//Text
                "What is the Nadir Solstitial?","25",//Choice1Text, Choice1ID
                "What happened to your body?","27"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "23","23",//Title, Id
                "Y-yes, Head Counselor. It’s me, (heroName). Are you… are you alright?” you ask, still somewhat fearful.\n" +
                        "\n" +
                        "Her spine-neck slithers over to you, differentiating to the fourth, fifth, and sixth orders as it goes. (I already took calculus back in high school.) The head slowly rises from the floor, until it’s at your height, and you’re directly face-to-face.\n" +
                        "\n" +
                        "Back before your most recent hibernation, Counselor Woebegone was quite a bit taller than you—as were most adult humans, being an elf and all, but she was tall even by human standards. She doesn’t bother positioning her head any higher now, though.\n" +
                        "\n" +
                        "“What do you think?” she asks, incredulously.\n" +
                        "\n" +
                        "“Uh…”\n" +
                        "\n" +
                        "“Of course I’m not alright! Obviously! I… Oh, sorry for snapping at you, (heroName), I know you’re just being the same polite sweetheart you were before the Nadir Solstitial. I’m… I am incredibly glad to see you. So by the standards of this new status quo… yes, I’m alright.”\n",//Text
                "I have questions","24",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "21","21",//Title, Id
                "Really, truly her. If her mind, and not just her body, had been altered to any significant degree, the contract would have been made null and void.\n" +
                        "\n" +
                        "You are a fool, and, now, a murderer. You deserve this.\n" +
                        "\n" +
                        "Where did it all go wrong? You’re supposed to be better than this—sillier than this!\n" +
                        "\n" +
                        "There is no time left to wonder. As your encroaching death begins to consume your magic itself, you use the very last of it to cast a spell of numbness over your body, and leap into the flames.\n" +
                        "\n" +
                        "You dissolve into sparkly fairy dust, and as it is propelled up the chimney, the last vestiges of your consciousness observe the world as it is now, truly comprehending at last that which was never meant to be comprehended by the minds of humans or elves:\n" +
                        "\n" +
                        "The true meaning… of “SUMMER”.\n" +
                        "\n" +
                        "You drift off to whatever fate awaits your kind beyond this life, hoping that you can be forgiven. The Eye Celestial, That Which Beholds, turns away from this pitiful sight… and all is darkness.\n",//Text
                "The end?",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "20","20",//Title, Id
                "With a grimace of disgust, and a gesture of your hand, the serpentine plasma rushes forward, ensnaring it, wreathing it in flames. And it writhes.\n" +
                        "\n" +
                        "Oh, it writhes.\n" +
                        "\n" +
                        "In agony. In the horror of betrayal. Its hideous limbs burn like so much kindling, as it shrieks in its terrible voice—terrible not in monstrousness, but in its complete, flawless imitation of humanity, with which it continues to mock your friend and mentor’s memory until the very last.\n" +
                        "\n" +
                        "And then it’s dead. Ashes and dust. The eclipse—fragmented and desynchronized across the window panes—ends.\n" +
                        "\n" +
                        "And then you begin to feel it. A creeping necrosis spreading across your limbs. And you remember.\n" +
                        "\n" +
                        "When Head Counselor Woebegone summoned you to this world, you made a deal, bound by the deepest of magics. And part of that deal… was that neither of you would ever harm the other. And if you did, you’d suffer the consequences.\n",//Text
                "So it was her","21",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "19","19",//Title, Id
                "Using your elf magic, you light the fireplace… and by sheer force of will, tendrils of pure flame begin to creep forward toward the thing that stole the Head Counselor’s face.\n" +
                        "\n" +
                        "“(heroName)… um, what are you doing?” the hideous impostor says, beginning to curl up its hideous limbs with a noise like bubblewrap, apparently preparing to stand up. “The fireplace doesn’t need to be lit right now—light and warmth aren’t exactly in short supply anymore.”\n" +
                        "\n" +
                        "Almost as if in response to its words, the suns in the window panes begin to be eclipsed, one by one. That’s not actually in response to its words, of course—they’re eyes, after all, not ears WAIT WHAT what are you saying they aren’t either of those things you DUMMY it is just the regular old SUN as REFLECTED through the windows OBVIOUSLY. Duh.\n" +
                        "\n" +
                        "You just barely manage to hold enough concentration to maintain the only light remaining: the twisting streams of fire, blazing brightly in the darkness. They’re nearly there now…\n" +
                        "\n" +
                        "“Wait… stop it, stop it! (heroName), I know this all seems strange, but I’m still Woebegone, your boss, your friend! You need to trust me! The fate of the world—”\n",//Text
                "Don't let it finish","20",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "18","18",//Title, Id
                "Her(?) neck Snaps™, Crackles™, and Pops™ sickeningly as she(?) turns her(?) gaze from one of the now-motionless ceiling fans to face you.\n" +
                        "\n" +
                        "“(heroName)???” Despite seemingly lacking any lungs, that’s Woebegone(?)’s voice, alright. A little older, a little hoarser, perhaps… but fundamentally the same. She(?) sounds astounded, but not in a bad way, and evidently recognizes you one way or another.\n" +
                        "\n" +
                        "And yet… well… the whole “freaky bone dragon” deal doesn’t exactly bode well as to this creature’s identity and intentions.\n" +
                        "\n" +
                        "But then again… Rice Krispie Treats™ always were Woebegone’s favorite.\n",//Text
                "Kill it with FIRE","19",//Choice1Text, Choice1ID
                "Trust her","23"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "16","16",//Title, Id
                "You pass into the serving area—empty, dusty, and thankfully windowless—and then into the main dining and meeting area in the center of the lodge.\n" +
                        "\n" +
                        "Due to a bizarre optical illusion and/or optical refraction/reflection thingy (I have yet to take Optics), you can see the sun glaring through every single pane of every single window, on both sides of the building, bathing every inch of the large, high room in a bloody red light. The fireplace is unlit, all of the tables and chairs have been put away, and across the floor…\n" +
                        "\n" +
                        "Sprawled chaotically across the otherwise empty floor lies a long, spindly organism. In its overall appearance, it resembles a bizarre parody of a dragon, yet its skin is not reptilian in nature, but almost… human. (Or elf, maybe—they’re pretty much the same.) Under its skin, it’s thin, terribly thin, more bones than flesh. And not just any kind of bones… every long, winding limb, every phalange of its wings, whether thick or thin, has all the knobbliness and flexibility of a spine. …It doesn’t look like it has any ribs. Even its head, the one exception to this thinness, seems as if it’s not so much supported by a skull as haphazardly stuffed with unconnected vertebrae until they were packed tight. Bulging. And on the front of this head, bizarrely out of place, as if it had somehow been copy/pasted there… lies the face of your beloved employer, Head Counselor Woebegone—a little older than you last saw her, maybe, but otherwise completely unchanged.\n",//Text
                "Woebegone? Is that you?","18",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "15","15",//Title, Id
                "That’s… that isn’t how… that MUST be how eclipses work, right? Whatever you may have heard about them in the past, you have now witnessed one with your own two elf eyes, and seeing is believing, after all.\n" +
                        "\n" +
                        "It happens again. The sunspot quickly moves from side to side, almost as if it was searching for… searching for…\n" +
                        "\n" +
                        "No. NO. Sunspots ARE NOT alive. They can’t “search” for something, and even if they could they wouldn’t actually be able to see anything on Earth, being, like, a million miles away and all.\n" +
                        "\n" +
                        "Something’s clearly messing with your head. Something apparently intent on deceiving you into thinking that the sun has somehow been replaced by some kind of freaky red eyeball, instead of undergoing perfectly natural astronomical phenomena as it obviously is (silly as you may be, you are SCIENTIFICALLY LITERATE, not a GULLIBLE MORON). Pretty epic prank, all things considered, but you’re feeling a headache coming on just thinking about it… You’re sure you’ll come to appreciate the Prankster Artistry involved in retrospect, but as it is you don’t really feel like dealing with it any more.\n",//Text
                "Moving on","16",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "14","14",//Title, Id
                "At first you thought it was looking at you, somehow (well, not you specifically, but somewhere in your general vicinity, at least), but now you’re pretty sure that’s just, like, a really big sunspot, not a pupil or anything. That wouldn’t make any sense!\n" +
                        "\n" +
                        "Hm… now that you’re paying closer attention to it, it seems like it’s a bit too high in the sky for it to be sunset or sunrise. Must be something in the air making it all reddish and stuff… Pollution? Wildfires? Either way, it’s a clue.\n" +
                        "\n" +
                        "Suddenly, everything goes dark… and equally suddenly, almost before you can process what just happened, it’s over, back to normal.\n" +
                        "\n" +
                        "Um, this is going to sound weird, but you could’ve sworn that the sun almost looked like it was…\n",//Text
                "An eclipse I guess","15",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "13","13",//Title, Id
                "There’s not much to explain. I mean, I’m sure you know what “water” means, and you probably know what “dehydrated” means, right? So if you take some water, and then dehydrate it, what do you get? It’s as simple as that.\n" +
                        "\n" +
                        "That’s what came out of the faucets when (heroName) tried to make use of any of the sinks.\n" +
                        "\n" +
                        "Anyways, I personally recommend Bernard Food Industries dehydrated water—they basically invented the stuff.\n" +
                        "\n" +
                        "(If you still don’t understand, don’t worry. It’s called… “dry humor”.)\n" +
                        "\n" +
                        "Moving on.\n",//Text
                "Look for clues","14",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "8","8",//Title, Id
                "You pace around the kitchen, looking for anything there that shouldn’t be—or anything that should be there but isn’t, but the only difference seems to be the lack of staff—other than yourself, anyways. Even the foodstuffs are all still in place, as far as you can tell.\n" +
                        "\n" +
                        "Actually, there is one thing that is missing… All of the staff hats, and even the hairnets, are gone. It looks like your head’s still going to remain bare for the foreseeable future.\n" +
                        "\n" +
                        "With a sigh, you turn to look out the window. Suddenly, a shiver runs down your spine. Is the sun… supposed to look like… that?\n" +
                        "\n" +
                        "Eh. It’s PROBABLY nothing.\n",//Text
                "What about the sun?!?","14",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "11","11",//Title, Id
                "“Pointless”? Elves aren’t supposed to have self-doubt, buddy. Get with the program!\n" +
                        "\n" +
                        "…The flour and stuff isn’t rotten, exactly, but it sure smells funny. And besides, you’re pretty sure cookies need, like, milk as an ingredient, right? You’re not totally sure, but that stuff’s looong gone, unless you’re willing to figure out how the powdered milk works.\n" +
                        "\n" +
                        "You think of making something other than cookies (Pasta, perhaps? That stuff looked relatively well-preserved…) but the stove’s heating seems to be about as effective as the cooling of the freezers has become (i.e. totally broken—the only thing that’s been keeping them as cold as they are is their insulation), and when you turn the faucet the water that comes out is way too dehydrated to be of any use.\n" +
                        "\n" +
                        "…Yeah, it seems like your quest was pretty pointless after all, wasn’t it. It’s a good thing that you weren’t using up any energy in your frozen state. Or maybe elves don’t actually, like, need to eat or drink, being creatures of magic and whimsy and all that? The mysteries of life…\n" +
                        "\n" +
                        "What will you do next?\n",//Text
                "Look for clues","8",//Choice1Text, Choice1ID
                "Dehydrated water?","13"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "10","10",//Title, Id
                "Huh. Seems like the rot’s gotten into this place, too.\n" +
                        "\n" +
                        "Figures.\n" +
                        "\n" +
                        "It doesn’t look like there’s anything of use for you here. Moving on.\n",//Text
                "Exit","11",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "9","9",//Title, Id
                "You don’t have any hollowed out trees on hand—at least not indoors, and you’re hesitant to go outside when it’s going to be getting dark soon, at least without a flashlight. That said, you will attempt to live up to the legacy of your commercialized archetypical antecedent to the utmost!!! Within the bounds of Fair-Use-protected parody, of course.\n" +
                        "\n" +
                        "You don’t actually have any idea how to cook—let’s just say that during camp your job involved dealing with the kids more directly than spending all your time brewing stuff up over here—but there’s a first time for everything. Hopefully Head Counselor Woebegone and/or her Acolytes won’t be too upset about your wanton misuse of camp resources… you’re just a silly elf, after all. What a scamp! Heheheheh. Hee. Hee.\n" +
                        "\n" +
                        "With those thoughts rattling around in your head, you turn around and head into the freezer for non-meat food, making sure to don both some thick oven mitts as well as every apron you can get your spindly elf hands on, wearing them both forwards and backwards, before plunging back into the cold—you know what they say about layers!\n",//Text
                "Enter other freezer","10",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "7","7",//Title, Id
                "You open the door, revealing a terrible sight…\n" +
                        "\n" +
                        "Before your very eyes, now widened with astonishment, you behold… oh saints above and spirits below, you behold…!\n" +
                        "\n" +
                        "An empty, dusty kitchen. Nothing out of place.\n" +
                        "\n" +
                        "You’re not sure what you expected.\n" +
                        "\n" +
                        "Given the lighting, it seems like the sun’s setting.\n" +
                        "\n" +
                        "What do you do?\n",//Text
                "Look for clues","8",//Choice1Text, Choice1ID
                "COOK!!!!","9"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "6","6",//Title, Id
                "You awkwardly shuffle over to the door, nearly slipping a couple of times—the floor is covered with a thin layer of half-melted iciness, giving it just about maximum slipperiness—until that “nearly” becomes a “fully and truly” just as you’re about to reach the metal door.\n" +
                        "\n" +
                        "You careen forward, your gravitational potential energy rapidly converting into kinetic energy both translational and rotational!! (I’m taking Classical Mechanics this semester.) Your elf forehead bonks against the hard surface, causing iridescent fractals to blossom across your eyeballs—and also pushing it open. You grab hold of the door handle just in time to prevent yourself from falling face-first onto your beautiful, fragile elf nose, and you manage to steady yourself, rise, and slide forward.\n" +
                        "\n" +
                        "Peering out through the partially open door, nothing seems amiss… the kitchen is empty, dark, and a bit dusty, but that figures.\n",//Text
                "Onwards!","7",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "4b","4b",//Title, Id
                "Oh dear, oh my! What could have possibly befallen this place?!?! you wonder. Perhaps… uh… the camp got shut down, leaving no one to maintain it—and leaving you behind? I mean… kinda weird that nobody bothered clearing out the place, but something along those lines is probably what happened, right?\n" +
                        "\n" +
                        "No! Not silly enough! Are you an elf or not?\n" +
                        "\n" +
                        "Maybe… this is… a dream? An… ice coma dream. You don’t remember having any of those before, but it’s more than possible that you just forgot. That’s still not that frivolous…\n" +
                        "\n" +
                        "You try flying with the power of lucid dreaming. Doesn’t work.\n" +
                        "Maybe… the camp was abandoned because of…\n" +
                        "\n" +
                        "Um…\n" +
                        "\n" +
                        "Zombies??? IDK.\n" +
                        "\n" +
                        "…Yeah, your Silliness Gauge seems to be on the down-low at the moment. Maybe your brain’s still a bit frozen up, so to speak. Or maybe, just maybe, it’s that elves are actually mythological beings with a rich, and perfectly serious, cultural heritage and you’ve just been forcing yourself to act “silly” just to conform to the modern-day stereotypical image of them this whole time?\n" +
                        "\n" +
                        "…Nah.\n",//Text
                "Exit freezer","6",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "2b","2b",//Title, Id
                "Ah yes, the wonders of meat! Flesh upon bloody flesh! You are surrounded by beautiful corpses ripe for consumption (your sharp elf teeth strong enough to gnaw into even the hardest death icicle, unthawed or not). Or perhaps… a bit overripe.\n" +
                        "\n" +
                        "You are now forced to reckon with a tremendous stench, which has only just now finished making its way down your long, pointy elf nose! The thick hunks of mystery meat have succumbed to an insidious rot. This confirms your earlier suspicion: something is wrong with the freezer, causing its temperature to drop below acceptable thresholds… and given that the rot has had enough time to take hold, it’s been this way for a while now. What happened here?\n",//Text
                "Speculate","4b",//Choice1Text, Choice1ID
                "Exit freezer","6"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "3","3",//Title, Id
                "You stretch your half-frozen muscles and ligaments, attaining a somewhat greater freedom of movement, rub your clammy hands together, and begin snapping the various icicles hanging off of you and scraping off the frozen film still covering the better part of your body.\n" +
                        "\n" +
                        "You then realize, with a dawning horror, that Head Counselor Woebegone left you here naked—naked! Or, well, she might as well have—you’re missing your silly elf hat! You feel a great, howling abyss open up in the depths of your soul, and know that you will never be…\n" +
                        "\n" +
                        "…\n" +
                        "\n" +
                        "Yeah, never mind. It’s just a hat. If you find it, awesome, but you won’t be holding your breath.\n" +
                        "\n" +
                        "Anyways, you’ve de-iced yourself enough to move about, albeit not very comfortably… Your elf knees are still locked up, but as long as your elf hip sockets are rotatable, you’re good to go for now. The rest can melt away when you get out of here and move on to warmer pastures.\n",//Text
                "Examine freezer","2b",//Choice1Text, Choice1ID
                "Exit freezer","6"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "4a","4a",//Title, Id
                "Oh dear, oh my! What could have possibly befallen this place?!?! you wonder. Perhaps… uh… the camp got shut down, leaving no one to maintain it—and leaving you behind? I mean… kinda weird that nobody bothered clearing out the place, but something along those lines is probably what happened, right?\n" +
                        "\n" +
                        "No! Not silly enough! Are you an elf or not?\n" +
                        "\n" +
                        "Maybe… this is… a dream? An… ice coma dream. You don’t remember having any of those before, but it’s more than possible that you just forgot. That’s still not that frivolous…\n" +
                        "\n" +
                        "You try melting the frost covering you with the power of lucid dreaming. Doesn’t work.\n" +
                        "Maybe… the camp was abandoned because of…\n" +
                        "\n" +
                        "Um…\n" +
                        "\n" +
                        "Zombies??? IDK.\n" +
                        "\n" +
                        "…Yeah, your Silliness Gauge seems to be on the down-low at the moment. Maybe your brain’s still a bit frozen up, so to speak. Or maybe, just maybe, it’s that elves are actually mythological beings with a rich, and perfectly serious, cultural heritage and you’ve just been forcing yourself to act “silly” just to conform to the modern-day stereotypical image of them this whole time?\n" +
                        "\n" +
                        "…Nah.\n",//Text
                "Escape frost","3",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "2a","2a",//Title, Id
                "Ah yes, the wonders of meat! Flesh upon bloody flesh! You are surrounded by beautiful corpses ripe for consumption (your sharp elf teeth strong enough to gnaw into even the hardest death icicle, unthawed or not). Or perhaps… a bit overripe.\n" +
                        "\n" +
                        "You are now forced to reckon with a tremendous stench, which has only just now finished making its way down your long, pointy elf nose! The thick hunks of mystery meat have succumbed to an insidious rot. This confirms your earlier suspicion: something is wrong with the freezer, causing its temperature to drop below acceptable thresholds… and given that the rot has had enough time to take hold, it’s been this way for a while now. What happened here?\n",//Text
                "Speculate","3",//Choice1Text, Choice1ID
                "Escape frost","4a"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "1","1",//Title, Id
                "As the muggy heat of summer washes over the countryside, you, (heroName) the Elf, emerge from your hibernation in the back of the meat freezer.\n" +
                        "\n" +
                        "…Wait, I’m sorry, what? You’re in a… a meat freezer? Something is seriously wrong here!\n" +
                        "\n" +
                        "Every previous summer, when the time for summer camp came around, Head Counselor Woebegone always took you out of the freezer before she defrosted you, and she doesn’t even seem to be in the room right now. It shouldn’t ever be warm enough inside the freezer for the ice encrusting your body to have thawed as much as it has! It seems that either something’s wrong with the freezer itself, or your elven biology has somehow become immune to cold—and you’re pretty sure that Santa’s employees are born that way.\n" +
                        "\n" +
                        "What will you do?\n",//Text
                "Examine meat freezer","2a",//Choice1Text, Choice1ID
                "Escape frost","3",//Choice2Text, Choice2ID
                true//isInitial (optional)

        ));

    }
}
