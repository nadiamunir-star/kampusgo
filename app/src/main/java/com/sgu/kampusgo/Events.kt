// Guided by Android Basics codelab: Add a scrollable list.
package com.sgu.kampusgo

data class Event(
    val id: String,
    val title: String,
    val category: String,
    val venue: String,
    val startsAt: String,
    val description: String
)

val sampleEvents = listOf(

    Event(
        id = "evt-01",
        title = "NMD Guest Lecture: Shipping on Play",
        category = "Academic",
        venue = "The Gade Campus, Room 5.03",
        startsAt = "2026-10-02T13:00:00+07:00",
        description = "A Play Console walkthrough from a former student. Bring a laptop if you want to follow the signing step. This description is intentionally long so your detail screen must scroll instead of clipping the last sentence off the bottom of a phone."
    ),

    Event(
        id = "evt-02",
        title = "UKM Programming: Hack night",
        category = "UKM",
        venue = "Lab C",
        startsAt = "2026-09-18T18:30:00+07:00",
        description = "Bring a charger. Snacks from Kantin Lt. 1."
    ),

    Event(
        id = "evt-03",
        title = "OSIS Town Hall",
        category = "Student org",
        venue = "Auditorium",
        startsAt = "2026-09-21T16:00:00+07:00",
        description = "Open mic for lab-fee and parking questions."
    ),

    Event(
        id = "evt-04",
        title = "Canteen promo: Nasi goreng Thursday",
        category = "Campus life",
        venue = "Kantin Lt. 1",
        startsAt = "2026-09-17T11:00:00+07:00",
        description = "Until supplies last."
    ),

    Event(
        id = "evt-05",
        title = "Career: internships at local startups",
        category = "Career",
        venue = "Hall B",
        startsAt = "2026-09-25T10:00:00+07:00",
        description = "CV clinic first 30 minutes."
    ),

    Event(
        id = "evt-06",
        title = "Futsal: FIT vs Business",
        category = "Sports",
        venue = "Lapangan BSD",
        startsAt = "2026-09-20T08:00:00+07:00",
        description = "Meet at lobby 07:15."
    ),

    Event(
        id = "evt-07",
        title = "Library research workshop",
        category = "Academic",
        venue = "Library training room",
        startsAt = "2026-09-23T14:00:00+07:00",
        description = "IEEE and ACM login, once."
    ),

    Event(
        id = "evt-08",
        title = "Past: Orientation recap screening",
        category = "Campus life",
        venue = "Student lounge",
        startsAt = "2026-08-20T15:00:00+07:00",
        description = "This event is in the past on purpose. Your list should still show it."
    )
)

